package org.chaos.scripts.runecrafter.jobs;

import org.chaos.core.job.ScriptJob;
import org.chaos.core.util.Format;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.chaos.scripts.runecrafter.ui.Gui;
import org.powerbot.script.methods.Skills;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaos_
 * @since 1.0 <11:56 PM - 08/11/13>
 */
public class GuiJob extends ScriptJob<Runecrafter> {

    private final JLabel[] jLabels;
    private final int startExp, startLvl;

    public GuiJob(Runecrafter script, Gui gui) {
        super(script);
        jLabels = gui.getJLabels();
        startExp = ctx.skills.getExperience(Skills.RUNECRAFTING);
        startLvl = ctx.skills.getLevel(Skills.RUNECRAFTING);
    }

    @Override
    public boolean condition() {
        //always run
        return true;
    }

    private List<String> getUpdates() {
        List<String> updates = new LinkedList<String>();
        final int[] stats = script.getStats();

        double essPerSec = stats[0]/(double)(script.getRuntime()/1000);
        int essPerHr = (int) Math.round(essPerSec * 3600);
        double runesPerSec = stats[1]/(double)(script.getRuntime()/1000);
        int runesPerHr = (int) Math.round(runesPerSec * 3600);
        double tripsPerSec = stats[2]/(double)(script.getRuntime()/1000);
        int tripsPerHr = (int) Math.round(tripsPerSec * 3600);

        int currExp = ctx.skills.getExperience(Skills.RUNECRAFTING);
        int gainedExp = currExp - startExp;
        double expPerSec = gainedExp/(double)(script.getRuntime()/1000);
        int expPerHr = (int) Math.round(expPerSec * 3600);

        int currLvl = ctx.skills.getLevel(Skills.RUNECRAFTING);
        int gainedLvl = currLvl - startLvl;
        String ttl = getTimeToLevel(Skills.RUNECRAFTING, currLvl + 1, expPerHr);

        updates.add("Timer: "+Format.time(script.getRuntime()));
        updates.add("Essence: "+stats[0]+" ("+essPerHr+"/hr)");
        updates.add("Runes: "+stats[1]+" ("+runesPerHr+"/hr)");
        updates.add("Trips: "+stats[2]+" ("+tripsPerHr+"/hr)");
        updates.add("Exp: "+gainedExp+" ("+expPerHr+"/hr)");
        updates.add("TTL: "+ttl+" ["+startLvl+" +"+gainedLvl+"]");
        updates.add("Status: "+script.getStatus());
        return updates;
    }

    private int getExperienceToLevel(int skill, int level) {
        return ctx.skills.getExperienceAt(level) - ctx.skills.getExperience(skill);
    }

    private String getTimeToLevel(int skill, int goal, int xpPerHour) {
        if (xpPerHour < 1) {
            return Format.time(0L);
        }
        return Format.time((long) (getExperienceToLevel(skill, goal) * 3600000D / xpPerHour));
    }

    @Override
    public void run() {
        for (;;) {
            try {
                List<String> data = getUpdates();
                for (int i = 0; i < jLabels.length; i++) {
                    JLabel j = jLabels[i];
                    String s = data.get(i);
                    j.setText(s);
                }
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

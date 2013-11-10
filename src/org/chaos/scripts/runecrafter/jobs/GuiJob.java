package org.chaos.scripts.runecrafter.jobs;

import org.chaos.core.job.ScriptJob;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.chaos.scripts.runecrafter.ui.Gui;

/**
 * @author chaos_
 * @since 1.0 <11:56 PM - 08/11/13>
 */
public class GuiJob extends ScriptJob<Runecrafter> {

    public GuiJob(Runecrafter script, Gui gui) {
        super(script);
    }

    @Override
    public boolean condition() {
        //always run
        return true;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

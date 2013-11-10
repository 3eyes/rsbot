package org.chaos.scripts.runecrafter;

import org.chaos.core.script.Script;
import org.chaos.scripts.runecrafter.actions.bank.BankerSet;
import org.chaos.scripts.runecrafter.actions.craft.CrafterSet;
import org.chaos.scripts.runecrafter.actions.walk.ToBank;
import org.chaos.scripts.runecrafter.actions.walk.ToSpot;
import org.chaos.scripts.runecrafter.data.Altar;
import org.chaos.scripts.runecrafter.jobs.GuiJob;
import org.chaos.scripts.runecrafter.ui.Gui;
import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.script.Manifest;

/**
 * @author chaos_
 * @since 1.0 <10:48 PM - 08/11/13>
 */
@Manifest(
    authors = "_chaos",
    name = "E3Runecrafter",
    description = "AIO F2P Runecrafter",
    version = 0.1
)
public class Runecrafter extends Script<Runecrafter> implements MessageListener {

    private Methods methods;
    private Gui gui;
    private Altar altar;

    private int essence = 0, runes = 0, trips = 0;

    public Runecrafter() {
        super();
        methods = new Methods(this);
    }

    @Override
    public void start() {
        gui = new Gui();
        while (!gui.start()) {
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        altar = gui.getAltar();
        submit(
            new ToBank(this),
            new BankerSet(this),
            new ToSpot(this),
            new CrafterSet(this)
        );
        reactor.exec().submit(new GuiJob(this, gui));
    }

    @Override
    public void messaged(MessageEvent e) {
        String s = e.getMessage();
        if (s.contains("powerful force take")) {
            essence += ctx.backpack.select().id(altar.getRune().getEssenceIds()).count();
        } else if (s.contains("step through the")) {
            int count = ctx.backpack.select().id(altar.getRuneId()).poll().getStackSize();
            runes += count;
            trips++;
        }
    }

    public Methods methods() {
        return methods;
    }

    public Altar altar() {
        return altar;
    }

    public int[] getStats() {
        return new int[] {essence, runes, trips};
    }

}

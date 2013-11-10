package org.chaos.scripts.runecrafter;

import org.chaos.core.script.Script;
import org.chaos.scripts.runecrafter.actions.bank.BankerSet;
import org.chaos.scripts.runecrafter.actions.craft.CrafterSet;
import org.chaos.scripts.runecrafter.actions.walk.ToBank;
import org.chaos.scripts.runecrafter.actions.walk.ToSpot;
import org.chaos.scripts.runecrafter.data.Altar;
import org.chaos.scripts.runecrafter.jobs.GuiJob;
import org.chaos.scripts.runecrafter.ui.Gui;
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
public class Runecrafter extends Script<Runecrafter> {

    private Methods methods;
    private Gui gui;
    private Altar altar;

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
        log.info(altar.toString());
        submit(
            new ToBank(this),
            new BankerSet(this),
            new ToSpot(this),
            new CrafterSet(this)
        );
        //reactor.exec().submit(new GuiJob(this, gui));
    }

    public Methods methods() {
        return methods;
    }

    public Altar altar() {
        return altar;
    }

}

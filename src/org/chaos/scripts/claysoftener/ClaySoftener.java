package org.chaos.scripts.claysoftener;

import org.chaos.core.script.Script;
import org.chaos.scripts.claysoftener.actions.bank.Banker;
import org.chaos.scripts.claysoftener.actions.soften.Softener;
import org.chaos.scripts.claysoftener.actions.walk.ToBank;
import org.chaos.scripts.claysoftener.actions.walk.ToSpot;
import org.chaos.scripts.claysoftener.data.Location;
import org.chaos.scripts.claysoftener.ui.Gui;
import org.chaos.scripts.claysoftener.ui.Stats;
import org.powerbot.script.Manifest;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author chaos_
 * @since 1.0 <10:03 PM - 05/11/13>
 */
@Manifest(
    authors = "_chaos",
    name = "ClaySoftener",
    description = "",
    version = 0.1
)
public class ClaySoftener extends Script<ClaySoftener> {

    private final Methods methods;
    private final Stats stats;
    private Location location;
    private Gui gui;

    private int claySoftened = 0;
    private int trips = 0;

    public ClaySoftener() {
        super();
        this.methods = new Methods(this);
        stats = new Stats(this);
    }

    public void start() {
        super.start();
        gui = new Gui(this);
        while (!gui.start()) {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        location = gui.getLoc();
        submit(
            new ToBank(this),
            new Banker(this),
            new ToSpot(this),
            new Softener(this)
        );
        reactor.exec().submit(gui);
    }

    public Methods methods() {
        return methods;
    }

    public Location location() {
        return location;
    }

    public void incrementClaySoftened(int inc) {
        claySoftened += inc;
    }

    public int getClaySoftened() {
        return claySoftened;
    }

    public void incrementTrips(int inc) {
        trips += inc;
    }

    public int getTrips() {
        return trips;
    }

    public boolean getMined() {
        return gui.getMined();
    }

    public List<String> getData() {
        return stats.getUpdates();
    }

}

package org.chaos.scripts.claysoftener.ui;

import org.chaos.core.util.Format;
import org.chaos.scripts.claysoftener.ClaySoftener;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chaos_
 * @since 1.0 <1:21 AM - 08/11/13>
 */
public class Stats {

    private final ClaySoftener script;
    private final int price;


    public Stats(ClaySoftener script) {
        this.script = script;
        price = script.getMined() ? 296 : 76;
    }

    public List<String> getUpdates() {
        List<String> updates = new LinkedList<String>();
        int clay = script.getClaySoftened();
        double clayPerSec = clay/(double)(script.getRuntime()/1000);
        int trips = script.getTrips();
        double tripsPerSec = trips/(double)(script.getRuntime()/1000);
        int profit = clay * price;
        double profitPerSec = profit/(double)(script.getRuntime()/1000);
        updates.add("Timer: "+ Format.time(script.getRuntime()));
        updates.add("Clay: "+clay);
        updates.add("Clay/Hr: "+(int) Math.round(clayPerSec*3600));
        updates.add("Trips: "+trips);
        updates.add("Trips/Hr: "+(int) Math.round(tripsPerSec*3600));
        updates.add("Profit: "+Format.toK(profit));
        updates.add("Profit/Hr: "+Format.toK((int) Math.round(profitPerSec*3600)));
        updates.add("Status: "+script.getStatus());
        return updates;
    }

}

package org.chaos.scripts.claysoftener.data;

import org.powerbot.script.wrappers.Player;
import org.powerbot.script.wrappers.Tile;

/**
 * @author chaos_
 * @since 1.0 <1:07 AM - 05/11/13>
 */
public enum Location {

    /**
     * Add special support for GE?
     * > North Fountain Tile(3164,3494)
     * > East  Fountain Tile(3167,3491)
     * > South Fountain Tile(3165,3489)
     * > West  Fountain Tile(3162,3492)
     * > ==============================
     * > NE Bank Tile(3178,3504)
     * > NW Bank Tile(3151,3504)
     * > SE Bank Tile(3178,3480)
     * > SW Bank Tile(3151,3480)
     *
     * Animation: 11490
     * Soften: Widget 1370, Component 38
     * Softening (+anim): Widget 1251
     */

    /*FALADOR_WEST(11661, new Tile[] {
        new Tile(2945, 3371, 0),
        new Tile(2950, 3381, 0)
    }),*/
    FALADOR_EAST(11759, new Tile[] {
        new Tile(3012, 3356, 0),
        new Tile(3023, 3361, 0),
        new Tile(3038, 3354, 0)
    }),
    VARROCK_EAST(24214, new Tile[] {
        new Tile(3252, 3422, 0),
        new Tile(3252, 3429, 0),
        new Tile(3238, 3434, 0)
    });
    /*GE maybe: 2771
    GRAND_EXCHANGE(47150, new Tile[] {
        new Tile(3178, 3504), //NE Bank Tile
        new Tile(3151, 3504), //NW Bank Tile
        new Tile(3178, 3480), //SE Bank Tile
        new Tile(3151, 3480)  //SW Bank Tile
    });*/

    private final int id;
    private final Tile[] path;

    private Location(int id, Tile[] path) {
        this.id = id;
        this.path = path;
    }

    public int waterId() {
        return id;
    }

    public Tile[] path() {
        return path;
    }

    public Tile getEndTile() {
        return path()[path().length-1];
    }

    public double distanceToEndTile(Player p) {
        return p.getLocation().distanceTo(getEndTile());
    }

}

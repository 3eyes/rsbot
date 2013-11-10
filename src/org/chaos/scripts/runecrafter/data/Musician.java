package org.chaos.scripts.runecrafter.data;

import org.powerbot.script.wrappers.Tile;

/**
 * @author chaos_
 * @since 1.0 <8:17 PM - 04/11/13>
 */
public enum Musician {

    AIR(8699, new Tile(3513, 3422)),
    MIND(-1, new Tile(-1 ,- 1)),
    WATER(-1, new Tile(-1 ,- 1)),
    EARTH(-1, new Tile(-1 ,- 1)),
    FIRE(-1, new Tile(-1 ,- 1)),
    BODY(-1, new Tile(-1 ,- 1));

    private final int id;
    private final Tile tile;

    private Musician(int id, Tile tile) {
        this.id = id;
        this.tile = tile;
    }

    public int getId() {
        return id;
    }

    public Tile getTile() {
        return tile;
    }

}

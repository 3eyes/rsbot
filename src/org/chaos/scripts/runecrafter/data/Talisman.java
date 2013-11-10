package org.chaos.scripts.runecrafter.data;

/**
 * @author chaos_
 * @since 1.0 <2:44 PM - 27/10/13>
 */
public enum Talisman {

    AIR(1438, 5527),
    MIND(1448, 5529),
    WATER(1444, 5531),
    EARTH(1440, 5535),
    FIRE(1442, 5537),
    BODY(1446, 5533);

    private final int[] ids;

    private Talisman(final int... ids) {
        this.ids = ids;
    }

    public int getTallyId() {
        return ids[0];
    }

    public int getTiaraId() {
        return ids[1];
    }

    public int[] getIds() {
        return ids;
    }

}

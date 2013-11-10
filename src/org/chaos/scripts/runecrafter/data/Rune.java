package org.chaos.scripts.runecrafter.data;

/**
 * @author chaos_
 * @since 1.0 <5:32 PM - 26/10/13>
 */
public enum Rune {

    ESSENCE(1436),
    PURE_ESSENCE(7936),
    AIR(556),
    MIND(558),
    WATER(555),
    EARTH(557),
    FIRE(554),
    BODY(559);
//    COSMIC(-1),
//    CHAOS(-1),
//    ASTRAL(-1),
//    NATURE(-1),
//    LAW(-1),
//    DEATH(-1),
//    BLOOD(-1);

    private final int runeId;

    private Rune(final int id) {
        this.runeId = id;
    }

    public int getRuneId() {
        return runeId;
    }

    public int getEssenceId() {
        return ESSENCE.getRuneId();
    }

    public int getPureEssenceId() {
        return PURE_ESSENCE.getRuneId();
    }

    public int[] getEssenceIds() {
        return new int[] {
            ESSENCE.getRuneId(), PURE_ESSENCE.getRuneId()
        };
    }

}

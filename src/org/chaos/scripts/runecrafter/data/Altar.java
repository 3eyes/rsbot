package org.chaos.scripts.runecrafter.data;

import org.powerbot.script.wrappers.Tile;

/**
 * @author chaos_
 * @since 1.0 <5:32 PM - 26/10/13>
 */
public enum Altar {

        AIR(Rune.AIR, AltarPath.AIR, Talisman.AIR, Musician.AIR, 2452, 2478, 2465, 1),
        MIND(Rune.MIND, AltarPath.MIND, Talisman.MIND, Musician.MIND, 2453, 2479, 2466, 2),
        WATER(Rune.WATER, AltarPath.WATER, Talisman.WATER, Musician.WATER, 2454, 2480, 2467, 5),
        EARTH(Rune.EARTH, AltarPath.EARTH, Talisman.EARTH, Musician.EARTH, 2455, 2481, 2468, 9),
        FIRE(Rune.FIRE, AltarPath.FIRE, Talisman.FIRE, Musician.FIRE, 2456, 2482, 2469, 14),
        BODY(Rune.BODY, AltarPath.BODY, Talisman.BODY, Musician.BODY, 2457, 2483, 2470, 20);
//    COSMIC(Rune.COSMIC, AltarPath.COSMIC, -1, -1, -1, 27),
//    CHAOS(Rune.CHAOS, AltarPath.CHAOS, -1, -1, -1, 35),
//    ASTRAL(Rune.ASTRAL, AltarPath.ASTRAL, -1, -1, -1, 40),
//    NATURE(Rune.NATURE, AltarPath.NATURE, -1, -1, -1, 44),
//    LAW(Rune.LAW, AltarPath.LAW, -1, -1, -1, 54),
//    DEATH(Rune.DEATH, AltarPath.DEATH, -1, -1, -1, 65),
//    BLOOD(Rune.BLOOD, AltarPath.BLOOD, -1, -1, -1, 77);

        private final Rune rune;
        private final AltarPath path;
        private final Talisman talisman;
        private final Musician musician;
        private final int ruinsId, altarId, portalId, rcReq;

        private Altar(final Rune rune, final AltarPath path, final Talisman talisman,
                      final Musician musician, final int ruinsId, final int altarId,
                      final int portalId, final int rcReq) {
                this.rune = rune;
                this.path = path;
                this.talisman = talisman;
                this.musician = musician;
                this.ruinsId = ruinsId;
                this.altarId = altarId;
                this.portalId = portalId;
                this.rcReq = rcReq;
        }

        public Rune getRune() {
                return rune;
        }

        public int getRuneId() {
                return rune.getRuneId();
        }

        public Tile[] getPath() {
                return path.getTiles();
        }

        public Tile getStartTile() {
                return getPath()[0];
        }

        public Tile getEndTile() {
                final Tile[] path = getPath();
                return path[path.length - 1];
        }

        public Talisman getTalisman() {
                return talisman;
        }

        public Musician getMusician() {
                return musician;
        }

        public int getRuinsId() {
                return ruinsId;
        }

        public int getAltarId() {
                return altarId;
        }

        public int getPortalId() {
                return portalId;
        }

        public int getRcReq() {
                return rcReq;
        }

}

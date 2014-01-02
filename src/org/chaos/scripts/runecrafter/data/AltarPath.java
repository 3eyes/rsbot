package org.chaos.scripts.runecrafter.data;

import org.powerbot.script.wrappers.Tile;

/**
 * @author chaos_
 * @since 1.0 <6:01 PM - 26/10/13>
 */
public enum AltarPath {

        AIR(new Tile[]{
                          new Tile(3187, 3439, 0),
                          new Tile(3187, 3429, 0),
                          new Tile(3174, 3429, 0),
                          new Tile(3158, 3419, 0),
                          new Tile(3137, 3411, 0),
                          new Tile(3129, 3403, 0)
        }),
        MIND(new Tile[]{
                           new Tile(2945, 3369, 0),
                           new Tile(2951, 3381, 0),
                           new Tile(2965, 3382, 0),
                           new Tile(2966, 3413, 0),
                           new Tile(2972, 3441, 0),
                           new Tile(2974, 3472, 0),
                           new Tile(2980, 3500, 0),
                           new Tile(2981, 3513, 0)
        }),
        WATER(new Tile[]{

        }),
        EARTH(new Tile[]{
                            new Tile(3254, 3420, 0),
                            new Tile(3254, 3429, 0),
                            new Tile(3283, 3429, 0),
                            new Tile(3288, 3459, 0),
                            new Tile(3307, 3473, 0)
        }),
        FIRE(new Tile[]{

        }),
        BODY(new Tile[]{
                           new Tile(3094, 3493, 0),
                           new Tile(3086, 3485, 0),
                           new Tile(3086, 3467, 0),
                           new Tile(3070, 3460, 0),
                           new Tile(3053, 3445, 0)
        });
//    COSMIC(new Tile[] {
//
//    }),
//    CHAOS(new Tile[] {
//
//    }),
//    ASTRAL(new Tile[] {
//
//    }),
//    NATURE(new Tile[] {
//
//    }),
//    LAW(new Tile[] {
//
//    }),
//    DEATH(new Tile[] {
//
//    }),
//    BLOOD(new Tile[] {
//
//    });

        private final Tile[] path;

        private AltarPath(final Tile[] path) {
                this.path = path;
        }

        public Tile[] getTiles() {
                return path;
        }

}

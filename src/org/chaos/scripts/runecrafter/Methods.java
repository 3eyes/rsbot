package org.chaos.scripts.runecrafter;

import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <6:13 PM - 09/11/13>
 */
public class Methods extends MethodProvider {

        private final Runecrafter script;

        public Methods(Runecrafter script) {
                super(script.getCtx());
                this.script = script;
        }

        public boolean canCraft() {
                return hasEssence() && (hasTalisman() || hasTiara());
        }

        public boolean hasTalisman() {
                return ctx.backpack.select().id(script.altar().getTalisman().getTallyId()).count() > 0;
        }

        public boolean hasTiara() {
                return ctx.equipment.select().id(script.altar().getTalisman().getTiaraId()).count() > 0;
        }

        public boolean hasEssence() {
                return ctx.backpack.select().id(script.altar().getRune().getEssenceIds()).count() > 0;
        }

        public boolean hasRunes() {
                return ctx.backpack.select().id(script.altar().getRuneId()).count() > 0;
        }

        public GameObject getRuins() {
                return ctx.objects.select().id(script.altar().getRuinsId()).poll();
        }

        public GameObject getAltar() {
                return ctx.objects.select().id(script.altar().getAltarId()).poll();
        }

        public GameObject getPortal() {
                return ctx.objects.select().id(script.altar().getPortalId()).poll();
        }

}

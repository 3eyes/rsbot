package org.chaos.scripts.runecrafter.actions.walk;

import org.chaos.core.action.generic.Traverse;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <11:45 PM - 08/11/13>
 */
public class ToSpot extends Traverse<Runecrafter> {

        public ToSpot(Runecrafter script) {
                super(script, script.altar().getPath());
        }

        @Override
        public boolean call() {
                final GameObject ruins = script.methods().getRuins();
                final GameObject portal = script.methods().getPortal();
                return script.methods().canCraft() && !ruins.isOnScreen()
                           && !portal.isValid() && !script.methods().hasRunes();
        }

        @Override
        public boolean execute() {
                script.setStatus("Walking to altar.");
                return super.execute();
        }

}

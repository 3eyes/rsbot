package org.chaos.scripts.runecrafter.actions.walk;

import org.chaos.core.action.generic.Traverse;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <11:45 PM - 08/11/13>
 */
public class ToBank extends Traverse<Runecrafter> {

        public ToBank(Runecrafter script) {
                super(script, script.altar().getPath(), true);
        }

        @Override
        public boolean call() {
                final GameObject altar = script.methods().getAltar();
                if (altar == null) {
                        return false;
                }
                return !script.methods().canCraft() && !altar.isValid()
                           && !ctx.bank.isOnScreen();
        }

        @Override
        public boolean execute() {
                script.setStatus("Walking to bank.");
                return super.execute();
        }

}

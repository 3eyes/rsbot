package org.chaos.scripts.runecrafter.actions.craft;

import org.chaos.core.action.ActionSet;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <11:45 PM - 08/11/13>
 */
public class CrafterSet extends ActionSet<Runecrafter> {

        public CrafterSet(Runecrafter script) {
                super(script);
                submit(
                          new Enter(script),
                          new Craft(script),
                          new Exit(script)
                );
        }

        @Override
        public boolean call() {
                final GameObject ruins = script.methods().getRuins();
                final GameObject altar = script.methods().getAltar();
                return script.methods().canCraft() && (ruins.isOnScreen() || altar.isOnScreen())
                           || !script.methods().canCraft() && altar.isOnScreen();
        }

}
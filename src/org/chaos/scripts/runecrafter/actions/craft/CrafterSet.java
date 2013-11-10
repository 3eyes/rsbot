package org.chaos.scripts.runecrafter.actions.craft;

import org.chaos.core.action.ActionSet;
import org.chaos.scripts.runecrafter.Runecrafter;

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
        return false;
    }

}
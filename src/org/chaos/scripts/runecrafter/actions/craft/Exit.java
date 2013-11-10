package org.chaos.scripts.runecrafter.actions.craft;

import org.chaos.core.action.generic.Interact;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.powerbot.script.lang.BasicNamedQuery;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <5:45 PM - 09/11/13>
 */
public class Exit extends Interact<Runecrafter, GameObject, BasicNamedQuery<GameObject>> {

    public Exit(Runecrafter script) {
        super(script, script.getContext().objects, "TODO:", script.altar().getPortalId());
    }

    @Override
    public boolean call() {
        return false;
    }

}


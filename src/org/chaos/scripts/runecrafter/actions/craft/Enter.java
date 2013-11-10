package org.chaos.scripts.runecrafter.actions.craft;

import org.chaos.core.action.generic.Interact;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.powerbot.script.lang.BasicNamedQuery;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <5:44 PM - 09/11/13>
 */
public class Enter extends Interact<Runecrafter, GameObject, BasicNamedQuery<GameObject>> {

    public Enter(Runecrafter script) {
        super(script, script.getContext().objects, "Enter", script.altar().getRuinsId());
    }

    @Override
    public boolean call() {
        final GameObject ruins = script.methods().getRuins();
        return script.methods().canCraft() && ruins.isValid();
    }

    @Override
    public boolean execute() {
        script.setStatus("Entering ruins.");
        return super.execute();
    }

}

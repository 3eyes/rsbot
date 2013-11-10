package org.chaos.scripts.claysoftener.actions.walk;

import org.chaos.core.action.generic.Traverse;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <6:21 PM - 06/11/13>
 */
public class ToSpot extends Traverse<ClaySoftener> {

    public ToSpot(ClaySoftener script) {
        super(script, script.location().path());
    }

    @Override
    public boolean call() {
        final GameObject fountain = ctx.objects.select().id(script.location().waterId()).nearest().poll();
        return script.methods().hasClay() && !fountain.isOnScreen();
                //&& (script.location().distanceToEndTile(local) >= 2 || !fountain.isOnScreen());
    }

    @Override
    public boolean execute() {
        script.setStatus("Walking to spot.");
        return super.execute();
    }

}

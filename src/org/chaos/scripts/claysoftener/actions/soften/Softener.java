package org.chaos.scripts.claysoftener.actions.soften;

import org.chaos.core.action.Action;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <3:59 PM - 06/11/13>
 */
public class Softener extends Action<ClaySoftener> {

    public Softener(ClaySoftener script) {
        super(script);
        submit(
            new UseFountain(script),
            new SoftenClay(script),
            new Wait(script)
        );
    }

    @Override
    public boolean call() {
        final GameObject water = ctx.objects.select().id(script.location().waterId()).nearest().poll();
        return script.methods().hasClay()
                && water.isOnScreen() && script.location().distanceToEndTile(local) <= 2;
    }

    @Override
    public boolean execute() {
        script.setStatus("Softening.");
        return true;
    }

}

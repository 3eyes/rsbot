package org.chaos.scripts.claysoftener.actions.walk;

import org.chaos.core.action.generic.Traverse;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.powerbot.script.wrappers.Interactive;
import org.powerbot.script.wrappers.Locatable;

/**
 * @author chaos_
 * @since 1.0 <6:21 PM - 06/11/13>
 */
public class ToBank extends Traverse<ClaySoftener> {

    public ToBank(ClaySoftener script) {
        super(script, script.location().path(), true);
    }

    @Override
    public boolean call() {
        final Locatable banker = ctx.bank.getNearest();
        return !script.methods().hasClay() && !((Interactive)banker).isOnScreen();
                //&& (local.getLocation().distanceTo(banker) >= 2 || !((Interactive)banker).isOnScreen());
    }

    @Override
    public boolean execute() {
        script.setStatus("Walking to bank.");
        return super.execute();
    }

}

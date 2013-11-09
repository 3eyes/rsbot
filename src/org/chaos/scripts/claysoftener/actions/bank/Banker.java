package org.chaos.scripts.claysoftener.actions.bank;

import org.chaos.core.action.Action;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.powerbot.script.wrappers.Interactive;
import org.powerbot.script.wrappers.Locatable;

/**
 * @author chaos_
 * @since 1.0 <3:55 PM - 06/11/13>
 */
public class Banker extends Action<ClaySoftener> {

    public Banker(ClaySoftener script) {
        super(script);
        submit(
            new Open(script),
            new Deposit(script),
            new Withdraw(script),
            new Close(script)
        );
    }

    @Override
    public boolean call() {
        final Locatable banker = ctx.bank.getNearest();
        return !script.methods().hasClay()
                && ((Interactive)banker).isOnScreen()
                //&& local.getLocation().distanceTo(banker) <= 2
                || ctx.bank.isOpen();
    }

    @Override
    public boolean execute() {
        script.setStatus("Banking.");
        return true;
    }

}

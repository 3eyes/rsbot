package org.chaos.scripts.claysoftener.actions.bank;

import org.chaos.core.action.Action;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.chaos.scripts.claysoftener.data.Clay;

/**
 * @author chaos_
 * @since 1.0 <6:23 PM - 06/11/13>
 */
public class Deposit extends Action<ClaySoftener> {

    public Deposit(ClaySoftener script) {
        super(script);
    }

    @Override
    public boolean call() {
        return ctx.bank.isOpen() && script.methods().hasSoftClay();
    }

    @Override
    public boolean execute() {
        script.setStatus("Depositing items.");
        script.incrementClaySoftened(ctx.backpack.select().id(Clay.SOFT_CLAY.id()).count());
        script.incrementTrips(1);
        return ctx.bank.depositInventory();
    }

}

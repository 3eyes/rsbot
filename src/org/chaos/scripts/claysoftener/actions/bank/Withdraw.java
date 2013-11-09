package org.chaos.scripts.claysoftener.actions.bank;

import org.chaos.core.action.Action;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.chaos.scripts.claysoftener.data.Clay;
import org.powerbot.script.methods.Bank;

/**
 * @author chaos_
 * @since 1.0 <6:23 PM - 06/11/13>
 */
public class Withdraw extends Action<ClaySoftener> {

    public Withdraw(ClaySoftener script) {
        super(script);
    }

    @Override
    public boolean call() {
        return ctx.bank.isOpen() && !script.methods().hasClay();
    }

    @Override
    public boolean execute() {
        script.setStatus("Withdrawing items.");
        return ctx.bank.withdraw(Clay.CLAY.id(), Bank.Amount.ALL);
    }

}
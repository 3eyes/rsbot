package org.chaos.scripts.runecrafter.actions.bank;

import org.chaos.core.action.Action;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.powerbot.script.methods.Bank;

/**
 * @author chaos_
 * @since 1.0 <5:20 PM - 09/11/13>
 */
public class Deposit extends Action<Runecrafter> {

    public Deposit(Runecrafter script) {
        super(script);
    }

    @Override
    public boolean call() {
        return ctx.bank.isOpen() && script.methods().hasRunes();
    }

    @Override
    public boolean execute() {
        script.setStatus("Depositing items.");
        return ctx.bank.deposit(script.altar().getRuneId(), Bank.Amount.ALL);
    }

}
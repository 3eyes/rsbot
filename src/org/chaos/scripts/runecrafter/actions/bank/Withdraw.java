package org.chaos.scripts.runecrafter.actions.bank;

import org.chaos.core.action.Action;
import org.chaos.scripts.runecrafter.Runecrafter;
import org.chaos.scripts.runecrafter.data.Rune;
import org.powerbot.script.methods.Bank;

/**
 * @author chaos_
 * @since 1.0 <5:20 PM - 09/11/13>
 */
public class Withdraw extends Action<Runecrafter> {

    public Withdraw(Runecrafter script) {
        super(script);
    }

    @Override
    public boolean call() {
        return ctx.bank.isOpen() && !script.methods().canCraft();
    }

    @Override
    public boolean execute() {
        script.setStatus("Withdrawing items.");
        final Rune rune = script.altar().getRune();
        return ctx.bank.withdraw(rune.getPureEssenceId(), Bank.Amount.ALL)
                || ctx.bank.withdraw(rune.getEssenceId(), Bank.Amount.ALL);
    }

}

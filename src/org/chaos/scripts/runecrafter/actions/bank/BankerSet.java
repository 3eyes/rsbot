package org.chaos.scripts.runecrafter.actions.bank;

import org.chaos.core.action.ActionSet;
import org.chaos.scripts.runecrafter.Runecrafter;

/**
 * @author chaos_
 * @since 1.0 <11:44 PM - 08/11/13>
 */
public class BankerSet extends ActionSet<Runecrafter> {

    public BankerSet(Runecrafter script) {
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
        return ctx.bank.isOnScreen() && !script.methods().canCraft()
                || ctx.bank.isOpen();
    }

}

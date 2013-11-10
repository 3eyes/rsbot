package org.chaos.scripts.runecrafter.actions.bank;

import org.chaos.core.action.Action;
import org.chaos.scripts.runecrafter.Runecrafter;

/**
 * @author chaos_
 * @since 1.0 <5:20 PM - 09/11/13>
 */
public class Close extends Action<Runecrafter> {

    public Close(Runecrafter script) {
        super(script);
    }

    @Override
    public boolean call() {
        return ctx.bank.isOpen() && script.methods().canCraft();
    }

    @Override
    public boolean execute() {
        return ctx.bank.close();
    }

}

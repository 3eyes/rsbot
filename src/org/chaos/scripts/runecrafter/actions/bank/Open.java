package org.chaos.scripts.runecrafter.actions.bank;

import org.chaos.core.action.Action;
import org.chaos.scripts.runecrafter.Runecrafter;

/**
 * @author chaos_
 * @since 1.0 <4:42 PM - 09/11/13>
 */
public class Open extends Action<Runecrafter> {

    public Open(Runecrafter script) {
        super(script);
    }

    @Override
    public boolean call() {
        return !ctx.bank.isOpen() && !script.methods().canCraft();
    }

    @Override
    public boolean execute() {
        script.setStatus("Opening bank.");
        return ctx.bank.open();
    }

    public int delay() {
        return 600;
    }

}

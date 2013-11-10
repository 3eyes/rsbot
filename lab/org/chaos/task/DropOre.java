package org.chaos.task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

/**
 * @author chaos_
 * @since 1.0 <3:10 PM - 09/11/13>
 */
public class DropOre extends Task {

    public DropOre(MethodContext ctx) {
        super(ctx);
    }

    private boolean invFull() {
        return ctx.backpack.select().count() == 28;
    }

    @Override
    public boolean activate() {
        return invFull();
    }

    @Override
    public void execute() {
        for (Item i : ctx.backpack) {
            i.interact("Drop");
            sleep(300, 500);
        }
    }

}

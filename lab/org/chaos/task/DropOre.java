package org.chaos.task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

/**
 * @author chaos_
 * @since 1.0 <3:10 PM - 09/11/13>
 *
 * This is the DropOre class of type Task.
 * In this class we will drop all ore once we have
 * achieved a full inventory.
 */
public class DropOre extends Task {

    public DropOre(MethodContext ctx) {
        super(ctx);
    }

    /**
     * This boolean checks whether or not the inventory
     * is full. It should be pretty much self explanatory.
     *
     * @return  Returns true if inventory count = 28,
     *          returns false if otherwise.
     */
    private boolean invFull() {
        return ctx.backpack.select().count() == 28;
    }

    /**
     * The activate condition of this Task.
     * It only activates when the inventory is full.
     *
     * @return  Returns true if inventory full,
     *          returns false if otherwise.
     */
    @Override
    public boolean activate() {
        return invFull();
    }

    /**
     * In the execute action of this Task, we will
     * loop over all items currently in the backpack,
     * and then perform the "Drop" action on them.
     */
    @Override
    public void execute() {
        /*
         * Using a for-each loop we iterate
         * through the contents of "ctx.backpack".
         * The object returned when iterating through
         * the backpack is an "Item", as shown on the left
         * hand side of the for-each loop.
         */
        for (Item i : ctx.backpack) {
            /*
             * We then perform the "Drop" action on
             * the item.
             */
            i.interact("Drop");
            /*
             * Pause for anywhere between 300-500 milliseconds
             * between every item dropped as to not spam drop
             * the ore and seem like a bot.
             *
             * We then go back to the top of this for-each loop
             * and continue iterating until all items have been
             * operated upon in the collection (ctx.backpack).
             */
            sleep(300, 500);
        }
    }

}

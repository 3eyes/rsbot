package org.chaos.task;

import org.chaos.Miner;
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

    /**
     * In the constructor of DropOre is the Mining script,
     * with a variable name of "script" for ease of reading.
     * From the script we extract the MethodContext so that the
     * requirement can be fulfilled when extending MethodProvider.
     *
     * Through the MethodContext we can access useful things
     * such as the Objects of the game, or the Npcs of the game.
     * The method context is basically the most important thing
     * when interacting directly with the clients code. All data
     * that you need directly from the client can be found here.
     *
     * @since 1.1   Changed the Task constructor from - Task(MethodContext ctx)
     *              to - Task(Miner script); this change was made to accommodate
     *              future expansion and configuration located in the Miner class.
     *
     * @param script    The MethodContext required when extending "MethodProvider"
     *                  is passed down from the Script when you initialize and put
     *                  the Tasks in the TaskList.
     */
    public DropOre(Miner script) {
        super(script);
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

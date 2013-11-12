package org.chaos.task;

import org.chaos.Miner;
import org.powerbot.script.wrappers.GameObject;

/**
 * @author chaos_
 * @since 1.0 <3:10 PM - 09/11/13>
 *
 * This is the MineOre class of type Task.
 * In this class we handle everything related to
 * the mining process. We first perform some checks,
 * and if they return true, we continue to the mining process.
 */
public class MineOre extends Task {

    /**
     * This is the ObjectID of the ore that we
     * wish to mine, it can be found through debugging
     * with the RSBot client. Currently it only
     * contains the IDs for tin ore at Varrock West mine.
     *
     * The reason this is a "private static final" is:
     *
     * private -> only accessible to methods within this class
     * static  -> only initialized once (created in memory by the JVM only once)
     * final   -> only assigned a value once, value does not change once assigned
     *
     * All of these things together create a Java "constant".
     * By convention constants have fully capitalized names.
     */
    private static final int[] ORE_IDS = { 11957, 11958, 11959 };

    /**
     * In the constructor of MineOre is the Mining script,
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
    public MineOre(Miner script) {
        super(script);
    }

    /**
     * This boolean checks for whether or not we have
     * space to mine more ore.
     *
     * @return  Returns true if the backpack has less than
     *          28 items in it, or else it will return false.
     *          In which case it means that our DropOre class
     *          would activate.
     */
    private boolean hasSpace() {
        return ctx.backpack.select().count() < 28;
    }

    /**
     * This boolean checks for whether or not the player
     * is already mining, to mitigate spam clicking the rock
     * when we are already mining; this check needs to be in place.
     *
     * @return  Returns true if the animation does not equal -1
     *          (meaning we are mining), false if it equals -1
     *          (meaning we are just standing around).
     */
    private boolean isMining() {
        return ctx.players.local().getAnimation() != -1;
    }

    /**
     * The activate boolean checks if the player isn't
     * Mining - notice the "!" mark before the isMining()
     * boolean to indicate we are checking for whether that
     * statement is false. If we wanted to check for whether
     * that statement is true we would have just put
     * "isMining()" vs "!isMining()".
     *
     * So this method checks for if inventory has space,
     * AND the player isn't currently mining, AND objects
     * with the ID "oreId" are present in the area. Settings
     * the conditions for your tasks to activate properly
     * is probably the hardest part of scripting.
     *
     * @return  Returns true if all checks return wanted value.
     *          hasSpace()                             -> should return true
     *          isMining()                             -> should return false
     *          ctx.objects.select.id(oreId).isEmpty() -> should return false
     *          If we want the task to execute().
     */
    @Override
    public boolean activate() {
        return hasSpace() && !isMining()
                /*
                 * The query is first cached here by using
                 * select() on all objects with the ids in
                 * - ORE_IDS - which is specified at the top of
                 * of this class. Queries are an advanced topic
                 * but for now just try to understand what
                 * you can from it.
                 */
                && !ctx.objects.select().id(ORE_IDS).isEmpty();
    }

    /**
     * If the activate condition returns true, then we
     * continue on with executing the task.
     */
    @Override
    public void execute() {
        /*
         * We first sort through our cached query with
         * nearest() and then we poll for an Object with
         * poll(). When trying to return an object from
         * the query, you will always almost use poll()
         * last.
         *
         * Note: If we we selected() again, the cached
         * query would be released and replaced with the
         * current one, taking advantage of this minimizes
         * code and increases efficiency/speed.
         */
        GameObject rock = ctx.objects.nearest().poll();
        /*
         * We first check if the rock is on screen.
         */
        if (rock.isOnScreen()) {
            /*
             * If it is -> then we continue the process
             * by "interacting" with the rock through
             * it's menu-option "Mine". All this data
             * must be gathered in-game by the scripter.
             */
            rock.interact("Mine");
        } else {
            /*
             * Else if the rock isn't on screen,
             * then -> we first step towards the rock
             * and then we turn our camera towards the
             * orientation of the rock relative to us.
             *
             * If the rock isn't on screen, we will not
             * mine it this loop in poll(). The script must
             * poll() again, select the correct task again,
             * and then if the rock is on screen it will
             * interact with it.
             */
            ctx.movement.stepTowards(rock);
            ctx.camera.turnTo(rock);
        }
    }

}

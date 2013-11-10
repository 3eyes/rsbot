package org.chaos.task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

/**
 * @author chaos_
 * @since 1.0 <3:08 PM - 09/11/13>
 *
 * This is an abstract Task class. The meaning of "abstract"
 * is that other classes can inherit the behaviours
 * - activate() and execute() - of this class by "extending" it.
 *
 * Eg.
 * <code>
 *     public class SomeClass extends Task {
 *
 *         public class SomeClass(MethodContext ctx) {
 *             super(ctx);
 *         }
 *
 *         public boolean activate() {
 *             return false;
 *         }
 *
 *         public void execute() {
 *             return false;
 *         }
 *     }
 * </code>
 *
 * It is not required by the Java compiler that the class:
 * SomeClass have both of the "abstract" methods defined in
 * the abstract class Task.
 *
 * The reason for this is so that we can treat all Tasks as
 * same "type" of Object in our Miner.java class. This technique
 * is implemented here:
 *
 * <code>
 *
 *     Remember that in the TaskList we have
 *     MineOre and DropOre, which are two different
 *     classes; but with the help of Java inheritance
 *     they can be treated as classes of the same type.
 *
 *     for (Task task : taskList) {
 *         if (task.activate()) {
 *             task.execute();
 *             return 300;
 *         }
 *     }
 *
 * </code>
 *
 * All tasks in TaskList are treated as the same type
 * of Object "Task" so that we can easily iterate through
 * the list and minimize the amount of code for dealing
 * with the same problem.
 */
public abstract class Task extends MethodProvider {

    /**
     * In the constructor of Task is the MethodContext,
     * through the MethodContext we can access useful things
     * such as the Objects of the game, or the Npcs of the game.
     * The method context is basically the most important thing
     * when interacting directly with the clients code. All data
     * that you need directly from the client can be found here.
     *
     * @param ctx   The MethodContext is passed down from the Script
     *              when you initialize and put the Tasks in the TaskList.
     *              Specifically here:
     *
     *              <code>
     *
     *                  taskList.add(new MineOre(getContext()));
     *                  taskList.add(new DropOre(getContext()));
     *
     *              </code>
     */
    public Task(MethodContext ctx) {
        super(ctx);
    }

    /**
     * The activate condition determines whether
     * or not the script should execute() this particular
     * task. Generally you only want to perform "checks" here
     * and not actually anything game related. All game related
     * actions should be handled in execute().
     *
     * @return  Returns true -> if the task should be activated,
     *          otherwise returns -> false and goes on to check
     *          other tasks.
     */
    public abstract boolean activate();

    /**
     * This method is called when activate() returns true.
     * This purpose of this should be pretty much self explanatory.
     * Check specific conditions on whether or not to execute task,
     * if true then execute().
     *
     * Again this is all handled in the Miner class when:
     *
     * <code>
     *
     *     for (Task task : taskList) {
     *         if (task.activate()) {
     *             task.execute();
     *             return 300;
     *         }
     *     }
     *
     * </code>
     */
    public abstract void execute();

}

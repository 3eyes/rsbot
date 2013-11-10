package org.chaos;

import org.chaos.task.DropOre;
import org.chaos.task.MineOre;
import org.chaos.task.Task;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaos_
 * @since 1.0 <2:57 PM - 09/11/13>
 *
 * This is the top layer class of the script. Behind the scenes
 * it is a Runnable task that is looped at a determinate amount
 * of time. Think of your script as a machine, and this being
 * the manual. All information regarding your script should
 * be centralized here, or a pointer to it (eg. in another class).
 */
@Manifest(
    authors = "_chaos",
    name = "PowerMiner",
    description = "PowerMiner tutorial script.",
    version = 1.0
)
public class Miner extends PollingScript {

    /**
     * This list holds the tasks that the script must execute. Think
     * of this as the instructions of your machine. If X arises do Y;
     * if A arises do B. This is the "core" of your script, and will
     * perform most of it not all of your game related tasks.
     */
    private List<Task> taskList = new ArrayList<Task>();

    /**
     * Just a normal Java constructor. Feel free to use this
     * to initialize any variables that you may want to use throughout
     * your script. I personally like to define my variables in the class
     * scope and then initialize them within the constructor.
     *
     * Eg:
     *
     * <code>
     *     public class SomeClass {
     *
     *         private final int time;
     *
     *         public SomeClass() {
     *             time = System.currentTimeMillis();
     *         }
     *     }
     * </code>
     *
     * The alternative to this would obviously be to just define
     * and initialize your variable in the class scope.
     *
     * Eg:
     *
     * <code>
     *     public class SomeClass {
     *
     *         private final int time = System.currentTimeMillis();
     *
     *         public SomeClass() {
     *
     *         }
     *     }
     * </code>
     */
    public Miner() {

    }

    /**
     * The control flow of the initiation of your script is:
     *
     * -> Script is started in the script selecting Gui
     * -> Your script is initialized, so in this case Miner() is called
     * -> Miner.start() runs before your script starts polling with poll()
     * -> Polls indefinitely with poll()
     *
     * It is important to understand this so you don't run into NullPointerException's
     * where you try to access something before it has been initialized. It is advisable
     * to add your Tasks to the TaskList here.
     */
    @Override
    public void start() {
        /*
         * Here we add the MineOre task and the DropOre task
         * to the TaskList. Expect your script to surpass
         * the 10+ tasks size margin in the future.
         */
        taskList.add(new MineOre(getContext()));
        taskList.add(new DropOre(getContext()));
    }

    /**
     * This method is what is continuously "polled" in the
     * background of your script. This is essentially the "Engine"
     * of your machine and handles all of the heavy lifting.
     * It runs in it's own thread - this script is a single threaded
     * environment. You can add more threads to your script as needed
     * but that is an advanced topic.
     *
     * @return  The return value of this is how long the script should
     *          wait before "polling" again. This unit is measured in milliseconds.
     *          1000 millis = 1 second
     */
    @Override
    public int poll() {
        /*
         * Here we loop over all the tasks that are in
         * the taskList, with a "for-each" loop. What this
         * means in english is: For each of the tasks in
         * the task array list do X action.
         *
         * This is the specific ArrayList being referenced here:
         * --> List<Task> taskList = new ArrayList<Task>();
         */
        for (Task task : taskList) {
            /*
             * For each Task : in TaskList
             *
             * First check if the Task should be activated()
             */
            if (task.activate()) {
                /*
                 * if so -> then execute() that specific task
                 */
                task.execute();
                /*
                 * then -> return a 300msec value, which instructs
                 * the script to wait 300msec before checking what task
                 * to execute next.
                 *
                 * Note this takes you back to the "top" of the - int poll() - method.
                 */
                return 300;
            }
        }
        /*
         * This statement is only reached when there are NO tasks
         * in the task list or NONE of the tasks activated. Otherwise
         * the previous return prevents the script from ever reaching to
         * this point.
         */
        return 300;
    }

}

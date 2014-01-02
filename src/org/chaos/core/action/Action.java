package org.chaos.core.action;

import org.chaos.core.script.Script;
import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.wrappers.Player;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author chaos_
 * @since 1.0 <10:08 PM - 05/11/13>
 */
public abstract class Action<T extends Script<T>> extends MethodProvider implements Comparable<Action<T>> {

        protected final BlockingQueue<Action<T>> chain;
        protected final T script;
        protected final Player local;
        protected final Priority priority;

        public Action(T script, Priority priority) {
                super(script.getCtx());
                this.priority = priority;
                this.script = script;
                local = script.getCtx().players.local();
                chain = new PriorityBlockingQueue<Action<T>>();
        }

        public Action(T script) {
                this(script, Priority.LOW);
        }

        public final BlockingQueue<Action<T>> chain() {
                return chain;
        }

        public final int getPriority() {
                return priority.get();
        }

        public final boolean submit(Action<T>... ab) {
                for (Action<T> a : ab) {
                        if (!chain.add(a))
                                return false;
                }
                return true;
        }

        @Override
        public int compareTo(Action<T> o) {
                return o.getPriority() - getPriority();
        }


        public int delay() {
        /*
         * Sub-classes can override if needed.
         */
                return 300;
        }

        public abstract boolean call();

        public abstract boolean execute();

}

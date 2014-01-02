package org.chaos.core.script;

import org.chaos.core.Reactor;
import org.chaos.core.action.Action;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.MethodContext;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;

/**
 * @author chaos_
 * @since 1.0 <10:03 PM - 05/11/13>
 */
public abstract class Script<T extends Script<T>> extends PollingScript {

        protected final Reactor reactor;
        protected final BlockingQueue<Action<T>> chain;

        protected String status = "";

        public Script() {
                reactor = new Reactor(this);
                chain = new PriorityBlockingQueue<Action<T>>();
        }

        public void start() {
                reactor.start();
        }

        @Override
        public final int poll() {
                try {
                        main:
                        for (Action<T> parent : chain) {
                                if (parent.call() && parent.execute()) {
                                        for (Action<T> child : parent.chain()) {
                                                if (!child.call() || !child.execute()) {
                                                        //TODO: ignore or break?
                                                        //continue main;
                                                }
                                                sleep(child.delay());
                                        }
                                }
                                sleep(parent.delay());
                        }
                } catch (Exception e) {
                        log.log(Level.SEVERE, "Script halted by exception", e);
                }
                return 240;
        }

        public final boolean submit(Action<T>... ab) {
                for (Action<T> a : ab) {
                        if (!chain.add(a))
                                return false;
                }
                return true;
        }

        public final void setStatus(String status) {
                this.status = status;
        }

        public final String getStatus() {
                return status;
        }

        public MethodContext getCtx() {
                return super.ctx;
        }

}

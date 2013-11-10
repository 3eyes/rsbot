package org.chaos.core;

import org.chaos.core.job.Job;
import org.chaos.core.job.ScriptJob;
import org.chaos.core.script.Script;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chaos_
 * @since 1.0 <8:07 PM - 31/10/13>
 */
public class Reactor implements Runnable {

    private final ExecutorService exec;

    private final Deque<Job> deque;

    private final Deque<Future<?>> futures;

    private final Logger log;

    public Reactor(Script script) {
        exec = Executors.newCachedThreadPool();
        deque = new LinkedBlockingDeque<Job>();
        futures = new LinkedList<Future<?>>();
        log = script.log;
    }

    public void start() {
        Executors.newSingleThreadExecutor().submit(this);
    }

    @Override
    public void run() {
        for (;;) {
            try {
                execute();

                Thread.sleep(300);
            } catch (Exception e) {
                log.log(Level.SEVERE, "Reactor halted by exception", e);
            }
        }
    }

    private void execute() throws Exception {
        for (Job j : deque) {
            if (j instanceof ScriptJob) {
                if (((ScriptJob)j).condition()) {
                    Future<?> f = exec.submit(j);
                    futures.add(f);
                }
            } else {
                Future<?> f = exec.submit(j);
                futures.add(f);
            }
        }
        /*
         * Although polling through futures
         * is unnecessary, to block the thread
         * while async executions are taking place
         * this is required.
         */
        for (Future<?> f : futures) {
            Object o = f.get();
            if (o == null) {
                //successful execution
            }
        }
    }

    public ExecutorService exec() {
        return exec;
    }

    public boolean submit(Job... jobs) {
        return Collections.addAll(deque, jobs);
    }

}

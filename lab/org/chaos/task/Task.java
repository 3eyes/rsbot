package org.chaos.task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

/**
 * @author chaos_
 * @since 1.0 <3:08 PM - 09/11/13>
 */
public abstract class Task extends MethodProvider {

    public Task(MethodContext ctx) {
        super(ctx);
    }

    public abstract boolean activate();
    public abstract boolean execute();

}

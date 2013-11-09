package org.chaos.core.job;

import org.chaos.core.script.Script;
import org.chaos.core.script.method.Provider;

/**
 * @author chaos_
 * @since 1.0 <8:14 PM - 31/10/13>
 */
public abstract class Job<T extends Script<T>> extends Provider implements Runnable {

    protected final T script;

    public Job(T script) {
        super(script.getContext());
        this.script = script;
    }

    public abstract boolean condition();

}

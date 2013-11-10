package org.chaos.core.job;

import org.chaos.core.script.Script;
import org.chaos.core.script.method.Provider;

/**
 * @author chaos_
 * @since 1.0 <11:48 PM - 08/11/13>
 */
public abstract class ScriptJob<T extends Script<T>> extends Provider implements Job {

    protected final T script;

    public ScriptJob(T script) {
        super(script.getContext());
        this.script = script;
    }

    public abstract boolean condition();

}


package org.chaos.core.action;

import org.chaos.core.script.Script;

/**
 * @author chaos_
 * @since 1.0 <4:43 PM - 09/11/13>
 */
public abstract class ActionSet<T extends Script<T>> extends Action<T> {

    public ActionSet(T script) {
        super(script);
    }

    public final int delay() {
        return 30;
    }

    public final boolean execute() {
        return true;
    }

}

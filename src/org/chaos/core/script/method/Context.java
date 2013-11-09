package org.chaos.core.script.method;

import org.powerbot.script.methods.MethodContext;

/**
 * @author chaos_
 * @since 1.0 <10:12 PM - 05/11/13>
 */
public class Context extends MethodContext {

    public Context(MethodContext parent) {
        super(parent.getBot());
    }

}

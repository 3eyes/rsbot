package org.chaos.core.script.method;

import org.powerbot.script.methods.MethodProvider;

/**
 * @author chaos_
 * @since 1.0 <10:13 PM - 05/11/13>
 */
public class Provider extends MethodProvider {

    protected final Context ctx;

    public Provider(Context ctx) {
        super(ctx);
        this.ctx = ctx;
    }

}

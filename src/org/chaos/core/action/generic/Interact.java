package org.chaos.core.action.generic;

import org.chaos.core.action.Action;
import org.chaos.core.script.Script;
import org.powerbot.script.lang.AbstractQuery;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.*;

import java.util.concurrent.Callable;

/**
 * @author chaos_
 * @author Coma
 * @since 1.0 <2:49 PM - 03/11/13>
 */
public abstract class Interact<T extends Script<T>,
                                  N extends Interactive & Identifiable & Nameable & Locatable,
                                  K extends AbstractQuery<K, N> & Identifiable.Query<K> & Nameable.Query<K> & Locatable.Query<K>>
    extends Action<T> {

        private final K query;
        private final String action;
        private final int[] ids;

        public Interact(T script, K query, String action, int... ids) {
                super(script);
                this.query = query;
                this.action = action;
                this.ids = ids;
        }

        protected final Callable<Boolean> next = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                        final Player player = ctx.players.local();
                        return !player.isInMotion() && player.getAnimation() == -1;
                }
        };

        @Override
        public boolean execute() {
                final N n = query.select().id(ids).nearest().poll();
                if (interact(n)) {
                        sleep(300);
                        return Condition.wait(next, 300, 10);
                }
                return false;
        }

        private boolean interact(N n) {
                if (n.isValid() && !n.isOnScreen()) {
                        ctx.movement.stepTowards(n);
                        ctx.camera.turnTo(n);
                }
                ctx.camera.turnTo(n);
                return n.interact(action);
        }

}

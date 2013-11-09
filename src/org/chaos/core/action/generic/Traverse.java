package org.chaos.core.action.generic;

import org.chaos.core.action.Action;
import org.chaos.core.script.Script;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.*;

import java.util.concurrent.Callable;

/**
 * @author chaos_
 * @since 1.0 <8:01 PM - 01/11/13>
 */
public abstract class Traverse<T extends Script<T>> extends Action<T> {

    protected final Path path;

    public Traverse(T script, Tile[] tiles, boolean reverse) {
        super(script);
        TilePath tPath = new TilePath(script.getContext(), tiles);
        path = reverse ? tPath.reverse() : tPath;
    }

    public Traverse(T script, Tile... tiles) {
        this(script, tiles, false);
    }

    protected final Callable<Boolean> nextStep = new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
            final Player player = ctx.players.local();
            return !player.isInMotion() || ctx.movement.getDestination().distanceTo(player) < 10;
        }
    };

    @Override
    public boolean execute() {
        return (path.traverse() || ctx.movement.stepTowards(path.getEnd()))
                && Condition.wait(nextStep, 300, 10);
    }


}

package org.chaos.scripts.claysoftener.actions.soften;

import org.chaos.core.action.Action;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.powerbot.script.util.Condition;

import java.util.concurrent.Callable;

/**
 * @author chaos_
 * @since 1.0 <10:31 PM - 06/11/13>
 */
public class Wait extends Action<ClaySoftener> {

    public Wait(ClaySoftener script) {
        super(script);
    }

    @Override
    public boolean call() {
        return script.methods().progressWidgetValid();
    }

    private final Callable<Boolean> finishedClay = new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
            return !script.methods().progressWidgetValid() || !script.methods().hasClay();
        }
    };

    @Override
    public boolean execute() {
        script.setStatus("Waiting to finish.");
        return Condition.wait(finishedClay, 600, 20);
    }

}

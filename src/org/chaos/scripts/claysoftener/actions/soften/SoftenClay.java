package org.chaos.scripts.claysoftener.actions.soften;

import org.chaos.core.action.Action;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.powerbot.script.wrappers.Component;

/**
 * @author chaos_
 * @since 1.0 <10:30 PM - 06/11/13>
 */
public class SoftenClay extends Action<ClaySoftener> {

    public SoftenClay(ClaySoftener script) {
        super(script);
    }

    @Override
    public boolean call() {
        return script.methods().hasClay() && script.methods().softenWidgetValid();
    }

    @Override
    public boolean execute() {
        script.setStatus("Softening clay.");
        final Component c = script.methods().getSoftenWidget();
        return c.isOnScreen() && c.click();
    }

}

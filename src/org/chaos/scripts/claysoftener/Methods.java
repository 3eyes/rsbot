package org.chaos.scripts.claysoftener;

import org.chaos.core.script.method.Provider;
import org.chaos.scripts.claysoftener.data.Clay;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Widget;

/**
 * @author chaos_
 * @since 1.0 <6:48 PM - 06/11/13>
 */
public class Methods extends Provider {

    private final ClaySoftener script;

    public Methods(ClaySoftener script) {
        super(script.getContext());
        this.script = script;
    }

    public GameObject getWaterObj() {
        return ctx.objects.select().id(script.location().waterId()).nearest().poll();
    }

    public boolean hasClay() {
        return ctx.backpack.select().id(Clay.CLAY.id()).count() > 0;
    }

    public boolean hasSoftClay() {
        return ctx.backpack.select().id(Clay.SOFT_CLAY.id()).count() > 0;
    }

    public boolean isSoftening() {
        return ctx.players.local().getAnimation() == SOFTEN_ANIMATION;
    }

    public Component getSoftenWidget() {
        return ctx.widgets.get(SOFTEN_PARENT_WIDGET, SOFTEN_CHILD_COMP);
    }

    public Widget getProgressWidget() {
        return ctx.widgets.get(SOFTEN_PROGRESS_WIDGET);
    }

    public boolean softenWidgetValid() {
        return getSoftenWidget().isValid();
    }

    public boolean progressWidgetValid() {
        return getProgressWidget().isValid();
    }

    private static final int SOFTEN_ANIMATION = 11490;
    private static final int SOFTEN_PARENT_WIDGET = 1370;
    private static final int SOFTEN_CHILD_COMP = 38;
    private static final int SOFTEN_PROGRESS_WIDGET = 1251;

}

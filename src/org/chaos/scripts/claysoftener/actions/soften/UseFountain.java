package org.chaos.scripts.claysoftener.actions.soften;

import org.chaos.core.action.Action;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.chaos.scripts.claysoftener.data.Clay;
import org.powerbot.script.methods.Hud;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;

import java.awt.*;

/**
 * @author chaos_
 * @since 1.0 <10:31 PM - 06/11/13>
 */
public class UseFountain extends Action<ClaySoftener> {

    public UseFountain(ClaySoftener script) {
        super(script);
    }

    @Override
    public boolean call() {
        return script.methods().hasClay()
                && !script.methods().isSoftening()
                && !script.methods().softenWidgetValid()
                && !script.methods().progressWidgetValid();
    }

    @Override
    public boolean execute() {
        script.setStatus("Using fountain.");
        final GameObject water = script.methods().getWaterObj();
        final Item item = ctx.backpack.select().id(Clay.CLAY.id()).poll();
        final Hud.Window backpack = Hud.Window.BACKPACK;
        if (!ctx.hud.isVisible(backpack)) {
            ctx.hud.view(backpack);
        }
        if (item.isValid() && water.isValid()) {
            if (item.interact("Use")) { //Use Clay
//                Point p = water.getCenterPoint();
//                return ctx.mouse.click(p, true); //Use Clay -> Wellpump/Fountain
                return water.interact("Use");
            }
        }
        return false;
    }

}

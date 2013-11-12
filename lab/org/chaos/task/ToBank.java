package org.chaos.task;

import org.chaos.Miner;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

/**
 * @author chaos_
 * @since 1.1 <2:55 PM - 10/11/13>
 */
public class ToBank extends Task {

    private static final Tile[] TO_BANK = new Tile[] {
        //TODO: generate a path from Varrock Bank to Varrock West Mine
    };

    private final TilePath bankPath;

    /**
     * In the constructor of ToBank is the Mining script,
     * with a variable name of "script" for ease of reading.
     * From the script we extract the MethodContext so that the
     * requirement can be fulfilled when extending MethodProvider.
     *
     * Through the MethodContext we can access useful things
     * such as the Objects of the game, or the Npcs of the game.
     * The method context is basically the most important thing
     * when interacting directly with the clients code. All data
     * that you need directly from the client can be found here.
     *
     * @since 1.1   Changed the Task constructor from - Task(MethodContext ctx)
     *              to - Task(Miner script); this change was made to accommodate
     *              future expansion and configuration located in the Miner class.
     *
     * @param script    The MethodContext required when extending "MethodProvider"
     *                  is passed down from the Script when you initialize and put
     *                  the Tasks in the TaskList.
     */
    public ToBank(Miner script) {
        super(script);
        bankPath = new TilePath(script.getContext(), TO_BANK);
    }

    private boolean needsBank() {
        return ctx.backpack.select().count() == 28;
    }

    private boolean atBank() {
        return ctx.bank.isOnScreen();
    }

    @Override
    public boolean activate() {
        return needsBank() && !atBank();
    }

    @Override
    public void execute() {
        bankPath.traverse();
    }

}

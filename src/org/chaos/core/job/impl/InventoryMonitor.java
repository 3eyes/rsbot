package org.chaos.core.job.impl;

import org.chaos.core.job.ScriptJob;
import org.chaos.core.script.Script;

/**
 * @author chaos_
 * @since 1.0 <11:53 PM - 08/11/13>
 */
public class InventoryMonitor<T extends Script<T>> extends ScriptJob<T> {
        public InventoryMonitor(T script) {
                super(script);
        }

        @Override
        public void run() {
        }

        @Override
        public boolean condition() {
                return false;
        }
}

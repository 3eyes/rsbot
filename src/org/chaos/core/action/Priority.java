package org.chaos.core.action;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chaos_
 * @since 1.0 <1:15 AM - 02/11/13>
 */
public enum Priority {

    LOW(1),
    MED(2),
    HIGH(3);

    private final AtomicInteger priority;

    private Priority(int priority) {
        this.priority = new AtomicInteger(priority);
    }

    public final int get() {
        return priority.get();
    }

}

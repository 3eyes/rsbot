package org.chaos.scripts.claysoftener.data;

/**
 * @author chaos_
 * @since 1.0 <1:05 AM - 05/11/13>
 */
public enum Clay {

    CLAY(434),
    SOFT_CLAY(1761);

    private final int id;

    private Clay(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

}

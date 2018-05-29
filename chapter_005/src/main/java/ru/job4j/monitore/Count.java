package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Count class.
 */
@ThreadSafe
public class Count {
    @GuardedBy("this")
    private int value;

    /**
     * Increment.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Getter to value.
     * @return int
     */
    public synchronized int get() {
        return this.value;
    }
}

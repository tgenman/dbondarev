package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {
    /**
     * Check counter from 0 to 10.
     */
    @Test
    public void addFromZeroToTen() {
        Counter example = new Counter();
        int rsl = example.add(0, 10);
        assertThat(rsl, is(30));
    }

    /**
     * Check counter from -10 to 10.
     */
    @Test
    public void addFromMinusTenToTen() {
        Counter example = new Counter();
        int rsl = example.add(-10, 10);
        assertThat(rsl, is(0));
    }
}

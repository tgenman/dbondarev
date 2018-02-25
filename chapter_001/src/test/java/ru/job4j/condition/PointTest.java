package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PointTest {
    /**
     * Check when point on line.
     */
    @Test
    public void whenPointOnLineThenTrue() {
        Point a = new Point(1, 1);
        boolean rsl = a.is(0, 1);
        assertThat(rsl, is(true));
    }

    /**
     * Check when point not on line.
     */
    @Test
    public void whenPointNotOnLineThenFalse() {
        Point a = new Point(1, 2);
        boolean rsl = a.is(0, 1);
        assertThat(rsl, is(false));
    }
}


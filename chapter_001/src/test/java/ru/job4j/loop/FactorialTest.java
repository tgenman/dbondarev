package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FactorialTest {
    @Test
    public void factorialFive() {
        Factorial example = new Factorial();
        int rsl = example.calc(5);
        assertThat(rsl, is(120));
    }

    @Test
    public void factorialZero() {
        Factorial example = new Factorial();
        int rsl = example.calc(0);
        assertThat(rsl, is(1));
    }
}

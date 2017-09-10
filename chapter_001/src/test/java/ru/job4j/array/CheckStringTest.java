package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CheckStringTest {
    @Test
    public void stringContainSubstring() {
        CheckString example = new CheckString();
        boolean out = example.contains("Привет", "иве");
        boolean expect = true;
        assertThat(out, is(expect));
    }

    @Test
    public void stringNotContainSubstring() {
        CheckString example = new CheckString();
        boolean out = example.contains("До Свидания", "иве");
        boolean expect = false;
        assertThat(out, is(expect));
    }
}

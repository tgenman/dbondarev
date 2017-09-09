package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn example = new Turn();
        int[] resultArray = example.back(new int[]{1, 2, 3, 4});
        int[] expectArray = {4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn example = new Turn();
        int[] resultArray = example.back(new int[]{1, 2, 3, 4, 5});
        int[] expectArray = {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }
}

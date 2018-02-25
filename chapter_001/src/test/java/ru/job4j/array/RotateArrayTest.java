package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class RotateArrayTest {
    /**
     * Check rotation when array contain two row and two column.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray example = new RotateArray();
        int[][] resultArray = example.rotate(new int[][]{{0, 1}, {10, 11}});
        int[][] expectArray = {{10, 0}, {11, 1}};
        assertThat(resultArray, is(expectArray));
    }

    /**
     * Check rotation when array contain three row and three column.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray example = new RotateArray();
        int[][] resultArray = example.rotate(new int[][]{{0, 1, 2}, {10, 11, 12}, {20, 21, 22}});
        int[][] expectArray = {{20, 10, 0}, {21, 11, 1}, {22, 12, 2}};
        assertThat(resultArray, is(expectArray));
    }

}

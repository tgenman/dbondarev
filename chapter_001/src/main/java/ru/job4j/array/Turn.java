package ru.job4j.array;
/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Turn.
     * @param array int[]
     * @return int[]
     */
    public int[] back(int[] array) {
        for (int i = 0; i <= array.length / 2 - 1; i++) {
            int buffer = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = buffer;
        }
        return array;
    }
}

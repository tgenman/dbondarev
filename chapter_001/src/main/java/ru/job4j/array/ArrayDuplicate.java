package ru.job4j.array;


import java.util.Arrays;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Remove Duplicate.
     * @param array of String[]
     * @return array of String[]
     */
    public String[] remove(String[] array) {
        int correctionLength = array.length;
        for (int out = 0; out < correctionLength; out++) {
            for (int in = out + 1; in < correctionLength; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = null;
                    array[in] = array[correctionLength - 1];
                    correctionLength--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, correctionLength);
    }
}

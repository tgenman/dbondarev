package ru.job4j.array;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RotateArray {

    public int[][] rotate(int[][] array) {
        int x = array[0].length;
        int y = array.length;
        int[][] result = new int[y][x];
        for (int i = 0; i <= y - 1 ; i++) {
            for (int j = 0; j <= x - 1 ; j++) {
                result[j][array[i].length - i - 1] = array[i][j];
            }
        }
        return result;
    }
}

package ru.job4j.array;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CheckString {

    public boolean contains(String origin, String sub) {
        char[] in = origin.toCharArray();
        char[] piece = sub.toCharArray();
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < piece.length; j++) {
                if (in[i] != piece[j]) {
                    continue;
                }
                if (j == (piece.length - 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

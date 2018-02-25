package ru.job4j.max;
/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Return max from two int.
     * @param first int
     * @param second int
     * @return max int
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    /**
     * Return max from three int.
     * @param first int
     * @param second int
     * @param third int
     * @return max int
     */
    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }
}

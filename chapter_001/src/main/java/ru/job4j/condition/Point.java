package ru.job4j.condition;
/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Point {
    /** Coordinate X. */
    private int x;
    /** Coordinate Y. */
    private int y;

    /**
     * Constructor.
     * @param x - coordinate x
     * @param y - coordinate y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return coordinate X.
     * @return int
     */
    public int getX() {
        return this.x;
    }

    /**
     * Return coordinate Y.
     * @return int
     */
    public int getY() {
        return this.y;
    }

    /**
     * Check to point to lay on line.
     * @param a parameter of line
     * @param b parameter of line
     * @return boolean
     */
    public boolean is(int a, int b) {
        return y == a * x + b;
    }
}

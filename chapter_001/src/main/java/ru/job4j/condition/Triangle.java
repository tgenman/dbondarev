package ru.job4j.condition;

/**
 * Class to triangle.
 * @author tgenman
 * @version 1.0
 */
public class Triangle {
    /** Point a. */
    private Point a;
    /** Point b. */
    private Point b;
    /** Point c. */
    private Point c;

    /**
     * Constructor.
     * @param a Point
     * @param b Point
     * @param c Point
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @param left Точка слева
     * @param right Точка с права.
     * @return расстояние между точками left и right.
     */
    public double distance(Point left, Point right) {
        return Math.sqrt(Math.pow(right.getX() - left.getX(), 2) + Math.pow(right.getY() - left.getY(), 2));
    }

    /**
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return полуПериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return Возможость построить треугольник с такими длинами сторон
     */
    private boolean exist(double ab, double ac, double bc) {
        if ((ab + ac) <= bc) {
            return false;
        }
        if ((ab + bc) <= ac) {
            return false;
        }
        if ((ac + bc) <= ab) {
            return false;
        }
        return true;
    }
}


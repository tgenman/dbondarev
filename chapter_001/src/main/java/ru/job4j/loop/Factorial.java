package ru.job4j.loop;
/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    public int calc(int n) {
        if (n == 0) {return 1;}
        int base = 1;
        for (int i = 1; i <= n; i++) {
            base *= i;
        }
        return base;
    }
}

package ru.job4j.calculator;

/**
 * Calculator
 * Created by tgenman on 8/26/17.
 */
public class Calculator {
    /**
     * Result of work.
     */
    private double result;

    /**
     * Add two double.
     * @param first double
     * @param second double
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract two double.
     * @param first double
     * @param second double
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Division two double.
     * @param first double
     * @param second double
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiple two double.
     * @param first double
     * @param second double
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Return result.
     * @return double
     */
    public double getResult() {
        return this.result;
    }



}

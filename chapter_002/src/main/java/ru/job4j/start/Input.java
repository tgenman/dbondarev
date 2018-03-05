package ru.job4j.start;

/**
 * Input interface.
 */
public interface Input {
    /**
     * Ask.
     * @param question String
     * @return String
     */
    String ask(String question);

    /**
     * Ask and check
     * @param question String
     * @param range to check
     * @return number of point menu
     */
    int ask(String question, int[] range);
}

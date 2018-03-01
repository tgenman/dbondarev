package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class to console input.
 * @author tgenman
 */
public class ConsoleInput implements Input {
    /**
     * Create instance of Scanner to read stdin.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask to user.
     * @param question String
     * @return String
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}

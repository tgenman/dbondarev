package ru.job4j.start;

import ru.job4j.tracker.MenuOutException;

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

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
			if (key == value) {
				exist = true;
				break;
			}
		}
		if (exist) {
        	return key;
		} else {
			throw new MenuOutException("Out of menu range");
		}
    }
}

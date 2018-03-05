package ru.job4j.start;

import ru.job4j.tracker.MenuOutException;

/**
 * Created by tgenman on 3/5/18.
 */
public class ValidateInput extends ConsoleInput {

	@Override
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value =  super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe) {
				System.out.println("Пожалуйста выберете ключ из меню");
			} catch (NumberFormatException nfe) {
				System.out.println("Пожалуйста введите корректные данные");
			}
		} while(invalid);
		return value;
	}
}

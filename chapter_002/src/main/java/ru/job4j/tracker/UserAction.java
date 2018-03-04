package ru.job4j.tracker;

import ru.job4j.start.Input;

/**
 * Created by tgenman on 3/4/18.
 */
public interface UserAction {

	/**
	 * Number of point of menu.
	 * @return number of point of menu.
	 */
	int key();

	/**
	 * Execure Action.
	 * @param input instance of Input
	 * @param tracker instance of Tracker
	 */
	void execute(Input input, Tracker tracker);

	/**
	 * Print point of menu.
	 * @return action description
	 */
	String info();
}

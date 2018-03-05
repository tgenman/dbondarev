package ru.job4j.tracker;

/**
 * @author tgenman
 * Created by tgenman on 3/5/18.
 */
public class MenuOutException extends RuntimeException {
	/**
	 * Constructor.
	 * @param msg messenge for User.
	 */
		public MenuOutException(String msg) {
		super(msg);
	}
}

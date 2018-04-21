package ru.job4j.map;

import java.util.Calendar;

/**
 * Override only hashCode.
 * Created by tgenman on 4/21/18.
 */
public class UserTwo {
	/** Name. */
	private String name;
	/** Children. */
	private int children;
	/** date of birthday. */
	private Calendar birthday;

	/**
	 * Constructor.
	 * @param name String
	 * @param children int
	 */
	public UserTwo(String name, int children) {
		this.name = name;
		this.children = children;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + children;
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		return result;
	}
}

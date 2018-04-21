package ru.job4j.map;

import java.util.Calendar;

/**
 * Don't override equals and hashCode.
 * Created by tgenman on 4/21/18.
 */
public class UserOne {
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
	public UserOne(String name, int children) {
		this.name = name;
		this.children = children;
	}
}

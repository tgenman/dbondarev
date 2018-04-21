package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tgenman on 4/21/18.
 */
public class User {
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
	public User(String name, int children) {
		this.name = name;
		this.children = children;
	}

	public static void main(String[] args) {
		User one = new User("Ivan", 3);
		User two = new User("Ivan", 3);
		Map<User, Object> testInstance = new HashMap<>();
		testInstance.put(one, 1);
		testInstance.put(two, 2);
		System.out.println(testInstance);
	}
}

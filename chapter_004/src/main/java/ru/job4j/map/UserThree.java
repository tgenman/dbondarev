package ru.job4j.map;

import java.util.Calendar;

/**
 * Override onle equals.
 * Created by tgenman on 4/21/18.
 */
public class UserThree {
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
	public UserThree(String name, int children) {
		this.name = name;
		this.children = children;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserThree userThree = (UserThree) o;

		if (children != userThree.children) return false;
		if (name != null ? !name.equals(userThree.name) : userThree.name != null) return false;
		return birthday != null ? birthday.equals(userThree.birthday) : userThree.birthday == null;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}

package ru.job4j.map;

import java.util.Calendar;

/**
 * Override Equals and HashCode.
 * Created by tgenman on 4/21/18.
 */
public class UserFour {
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
	public UserFour(String name, int children) {
		this.name = name;
		this.children = children;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserFour userFour = (UserFour) o;

		if (children != userFour.children) return false;
		if (name != null ? !name.equals(userFour.name) : userFour.name != null) return false;
		return birthday != null ? birthday.equals(userFour.birthday) : userFour.birthday == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + children;
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		return result;
	}
}

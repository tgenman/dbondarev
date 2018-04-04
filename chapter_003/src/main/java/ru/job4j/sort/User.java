package ru.job4j.sort;

/**
 * Created by tgenman on 4/3/18.
 */
public class User implements Comparable<User> {
	/** Name. */
	private String name;

	/** Age. */
	private int age;

	/**
	 * Constructor.
	 * @param name String
	 * @param age int
	 */
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(User user) {
		int result = this.name.compareTo(user.name);
		if (result == 0) {
			Integer wrapAge = this.age;
			result = wrapAge.compareTo(user.age);
		}
		return result;
	}

	/**
	 * getter Name.
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter Age.
	 * @return Age
	 */
	public int getAge() {
		return age;
	}
}

package ru.job4j.bank;

/**
 * Created by tgenman on 4/4/18.
 */
public class User {
	/** Name. */
	private final String name;

	/** Passport. */
	private final String passport;

	/**
	 * Constructor.
	 * @param name String
	 * @param passport String
	 */
	public User(String name, String passport) {
		this.name = name;
		this.passport = passport;
	}

	/**
	 * Getter Name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter Passport.
	 * @return String
	 */
	public String getPassport() {
		return passport;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		User user = (User) o;

		if (name != null ? !name.equals(user.name) : user.name != null) {
			return false;
		}
		return passport != null ? passport.equals(user.passport) : user.passport == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (passport != null ? passport.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{"
				+ "name='" + name + '\''
				+ ", passport='" + passport + '\''
				+ '}';
	}
}

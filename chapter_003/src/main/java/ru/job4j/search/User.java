package ru.job4j.search;

/**
 * Created by tgenman on 3/23/18.
 */
public class User {
	/** id. */
	private int id;

	/** name. */
	private String name;

	/** city. */
	private String city;

	/**
	 * Constructor.
	 * @param id int
	 * @param name String
	 * @param city String
	 */
	public User(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	/**
	 * Getter id.
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter Name.
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter City.
	 * @return City
	 */
	public String getCity() {
		return city;
	}
}

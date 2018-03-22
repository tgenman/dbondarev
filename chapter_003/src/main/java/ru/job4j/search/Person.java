package ru.job4j.search;

/**
 * Created by tgenman on 3/22/18.
 */
public class Person {
	/** Name. */
	private String name;

	/** Surname. */
	private String surname;

	/** Phone. */
	private String phone;

	/** Address. */
	private String address;

	/**
	 * Constructor.
	 * @param name String
	 * @param surname String
	 * @param phone String
	 * @param address String
	 */
	public Person(String name, String surname, String phone, String address) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
	}

	/**
	 * Getter Name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gtter Surname.
	 * @return String
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Getter Phone.
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Getter Adress.
	 * @return String
	 */
	public String getAddress() {
		return address;
	}
}
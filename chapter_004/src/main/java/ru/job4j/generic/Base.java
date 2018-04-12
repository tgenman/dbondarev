package ru.job4j.generic;

/**
 * Created by tgenman on 4/12/18.
 */

public abstract class Base {
	/** id. */
	private final String id;

	/**
	 * Constructor.
	 * @param id String
	 */
	protected Base(final String id) {
		this.id = id;
	}

	/**
	 * Getter id.
	 * @return String
	 */
	public String getId() {
		return id;
	}

}

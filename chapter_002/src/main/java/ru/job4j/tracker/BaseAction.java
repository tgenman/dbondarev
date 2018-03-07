package ru.job4j.tracker;

/**
 * Created by tgenman on 3/7/18.
 */
public abstract class BaseAction implements UserAction {
	/** Number of point menu. */
	private final int key;
	/** Name of point menu. */
	private final String name;

	/**
	 * Constructor.
	 * @param key int number of point menu
	 * @param name String name of point menu
	 */
	BaseAction(final int key, final String name) {
		this.key = key;
		this.name = name;
	}

	@Override
	public int key() {
		return this.key;
	}

	@Override
	public String info() {
		return String.format("%s. %s", this.key, this.name);
	}
}

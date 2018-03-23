package ru.job4j.search;

/**
 * Created by tgenman on 3/22/18.
 */
public class Task {
	/** Description of Task. */
	private String desc;

	/** Priority of Task. */
	private int priority;

	/**
	 * Constructor.
	 * @param desc Description
	 * @param priority Priority
	 */
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}

	/**
	 * Getter Description.
	 * @return String
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Getter Priority.
	 * @return String
	 */
	public int getPriority() {
		return priority;
	}
}


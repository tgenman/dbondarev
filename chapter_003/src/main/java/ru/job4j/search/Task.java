package ru.job4j.search;

/**
 * Created by tgenman on 3/22/18.
 */
public class Task {
	private String desc;
	private int priority;

	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}

	public String getDesc() {
		return desc;
	}

	public int getPriority() {
		return priority;
	}
}


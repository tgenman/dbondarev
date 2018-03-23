package ru.job4j.search;

import java.util.LinkedList;

/**
 * Created by tgenman on 3/22/18.
 */
public class PriorityQueue {
	/** List of Tasks. */
	private LinkedList<Task> tasks = new LinkedList<>();

	/**
	 * Метод должен вставлять в нужную позицию элемент.
	 * Позиция определять по полю приоритет.
	 * Для вставик использовать add(int index, E value)
	 * @param task задача
	 */
	public void put(Task task) {
		if (tasks.isEmpty()) {
			tasks.add(task);
			return;
		}
		int index = 0;
		for (Task value: tasks) {
			if (value != null
					&& (task.getPriority() <= value.getPriority())) {
				break;
			}
		index++;
		}
		tasks.add(index, task);
	}

	/**
	 * Take first Task.
	 * @return Task
	 */
	public Task take() {
		return this.tasks.poll();
	}
}

package ru.job4j.search;

import java.util.LinkedList;

/**
 * Created by tgenman on 3/22/18.
 */
public class PriorityQueue {
//	private LinkedList<Task> tasks = new LinkedList<>();
//
//	/**
//	 * Метод должен вставлять в нужную позицию элемент.
//	 * Позиция определять по полю приоритет.
//	 * Для вставик использовать add(int index, E value)
//	 * @param task задача
//	 */
//	public void put(Task task) {
//		System.out.println(tasks.isEmpty());
//		if (tasks.isEmpty()) {
//			System.out.println("2");
//			tasks.add(task);
//			return;
//		}
//		System.out.println("3");
//
//		for (Task value: tasks) {
//			System.out.println("inner");
//			System.out.println(value != null && (task.getPriority() <= value.getPriority()));
//			if (value != null && (task.getPriority() <= value.getPriority())) {
//			tasks.add(task);System.out.println("end");
//			}
//			System.out.println("end of loop");
//		}
//		System.out.println("enf of method");
//	}
//
//	public Task take() {
//		return this.tasks.poll();
//	}
}

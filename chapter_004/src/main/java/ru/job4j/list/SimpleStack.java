//package ru.job4j.list;
//
///**
// * Created by tgenman on 4/13/18.
// * @param <T> T
// */
//public class SimpleStack<T> {
//	/**Container. */
//	private final SimpleLinkedList<T> container = new SimpleLinkedList<>();
//
//	/**
//	 * Size.
//	 * @return int
//	 */
//	public int size() {
//		return container.size();
//	}
//
//	/**
//	 * Push.
//	 * @param value T
//	 */
//	public void push(T value) {
//		container.add(value);
//	}
//
//	/**
//	 * Poll.
//	 * @return T
//	 */
//	public T poll() {
//		T item = container.get(container.size() - 1);
//		container.remove(item);
//		return item;
//	}
//}

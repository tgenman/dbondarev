package ru.job4j.list;


/**
 * Created by tgenman on 4/13/18.
 * @param <T> T
 */
public class SimpleQueue<T> {
	/**Container. */
	private final SimpleLinkedList<T> container = new SimpleLinkedList<>();

//	private final LinkedList<T> container = new LinkedList<>();
	/**
	 * Size.
	 * @return int
	 */
	public int size() {
		return container.size();
	}

	/**
	 * Push.
	 * @param value T
	 */
	public void push(T value) {
		container.add(value);
	}

	/**
	 * Poll.
	 * @return T
	 */
	public T poll() {
		T item = container.get(0);
		container.remove(0);
		return item;
	}
}

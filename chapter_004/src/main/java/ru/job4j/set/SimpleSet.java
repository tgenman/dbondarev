package ru.job4j.set;

import ru.job4j.list.DynamicArray;

import java.util.Iterator;

/**
 *  Created by tgenman on 4/19/18.
 * @param <T> T
 */
public class SimpleSet<T> implements Iterable<T> {
	/**Container. */
	private final DynamicArray container = new DynamicArray();

	/**
	 * Size.
	 * @return size.
	 */
	public int size() {
		return this.container.size();
	}

	/**
	 * isEmpty.
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.container.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return container.iterator();
	}

	/**
	 * add.
	 * @param e T
	 */
	public void add(T e) {
		if (!container.contains(e)) {
			container.add(e);
		}
	}

	/**
	 * Contains.
	 * @param sample T
	 * @return boolean
	 */
	public boolean contains(T sample)  {
		return this.container.contains(sample);
	}

}

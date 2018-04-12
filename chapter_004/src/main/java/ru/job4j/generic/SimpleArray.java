package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleArray.
 * @param <T> Class of element.
 */
public class SimpleArray<T> implements Iterable<T> {

	/**Conteiner. */
	private T[] container = (T[]) new Object[1];

	/** Size. */
	private int size;

	/**
	 * Size.
	 * @return size.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * isEmpty.
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * add.
	 * @param model T
	 */
	public void add(T model) {
		if (container.length == size) {
			final T[] oldM = container;
			container = (T[]) new Object[this.size() * 2];
			System.arraycopy(oldM, 0, container, 0, oldM.length);
		}
		container[size++] = model;
	}

	/**
	 * Set.
	 * @param index int
	 * @param model T
	 */
	public void set(int index, T model) {
		if (index < this.size) {
			container[index] = model;
		}
	}

	/**
	 * Delete.
	 * @param index int.
	 */
	public void delete(int index) {
		if (index < this.size) {
			if (index != this.size - 1) {
				System.arraycopy(container, index + 1, container, index, this.size() - index - 1);
			}
			size--;
		}
	}

	/**
	 * get.
	 * @param index int
	 * @return T
	 */
	public T get(int index) {
		return container[index];
	}

	/**
	 * Return index of element.
	 * @param element T
	 * @return int
	 */
	public int getIndex(T element) {
		for (int i = 0; i < size; i++) {
			if (container[i] == null) {
				continue;
			}
			if (container[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new SimpleIterator();
	}

	/**
	 * Iterator.
	 */
	private class SimpleIterator implements Iterator<T> {

		/** Index. */
		private int index;

		/** Index of last returned. */
		private int last = -1;

		@Override
		public boolean hasNext() {
			return SimpleArray.this.size() > index;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			last = index;
			return SimpleArray.this.container[index++];
		}
	}

}

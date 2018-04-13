package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tgenman on 4/13/18.
 * @param <T> T
 */
public class DynamicArray<T> implements Iterable<T> {

	/**Container. */
	private T[] container = (T[]) new Object[1];

	/** Size. */
	private int size;

	/** Counter of modifications. */
	private int modCount;

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
		modCount++;
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
			modCount++;
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
		return new DynamicArrayIterator();
	}

	/**
	 * Iterator.
	 */

	private class DynamicArrayIterator implements Iterator {

		/** Index. */
		private int index;

		/** Index of last returned. */
		private int last = -1;

		/**
		 * Value of count when create iterator.
		 */
		private int expectedModCount;

		/**
		 * Constructor.
		 */
		private DynamicArrayIterator() {
			this.expectedModCount = DynamicArray.this.modCount;
		}

		@Override
		public boolean hasNext() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			return DynamicArray.this.size > index;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			last = index;
			return DynamicArray.this.container[index++];
		}
	}
}

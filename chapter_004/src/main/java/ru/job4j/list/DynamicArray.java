package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tgenman on 4/13/18.
 * @param <T> T
 */
@ThreadSafe
public class DynamicArray<T> implements Iterable<T> {

	/**Container. */
	@GuardedBy("this")
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
		return size == 0;
	}

	/**
	 * add.
	 * @param model T
	 */
	public synchronized void add(T model) {
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
	public synchronized void set(int index, T model) {
			container[index] = model;
	}

	/**
	 * Delete.
	 * @param index int.
	 */
	public synchronized void delete(int index) {
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
	public synchronized T get(int index) {
		return container[index];
	}

	/**
	 * Return index of element.
	 * @param element T
	 * @return int
	 */
	public synchronized int getIndex(T element) {
		for (int i = 0; i < size; i++) {
			if (container[i] != null
					&& container[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Contains.
	 * @param sample T
	 * @return boolean
	 */
	public boolean contains(T sample)  {
		boolean result = false;
		for (T item : this) {
			if (sample.equals(item)) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		return new DynamicArrayIterator();
	}

	/**
	 * Iterator.
	 */
	@ThreadSafe
	private class DynamicArrayIterator implements Iterator {

		/** Index. */
		@GuardedBy("this")
		private int index;

		/**
		 * Value of count when create iterator.
		 */
		private final int expectedModCount;

		/**
		 * Constructor.
		 */
		private DynamicArrayIterator() {
			this.expectedModCount = DynamicArray.this.modCount;
		}

		@Override
		public synchronized boolean hasNext() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			return DynamicArray.this.size > index;
		}

		@Override
		public synchronized T next() {
			synchronized (DynamicArray.this) {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return DynamicArray.this.container[index++];
			}

		}
	}
}

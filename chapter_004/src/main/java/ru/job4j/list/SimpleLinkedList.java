package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tgenman on 4/13/18.
 * @param <T> T
 */
public class SimpleLinkedList<T> implements Iterable<T> {
	/** Link to first Node. */
	private Node<T> firstInList = null;

	/** Link to last Node. */
	private Node<T> lastInList = null;

	/** Size. */
	private int size;

	/** Counter of modifications. */
	private int modCount;

	/**
	 * Size.
	 * @return int size
	 */
	public int size() {
		return this.size;
	}

	/**
	 * isEmpty.
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Add.
	 * @param newElement T
	 * @return boolean
	 */
	public boolean add(final T newElement) {
		if (firstInList == null
				&& lastInList == null) {
			Node<T> temp = new Node<>(newElement, null, null);
			firstInList = temp;
			lastInList = temp;

		} else {
			Node<T> temp = new Node<>(newElement, lastInList, null);
			lastInList = temp;
			temp.prevNode.nextNode = temp;
		}
		size++;
		modCount++;
		return true;
	}

	/**
	 * Get by index.
	 * @param index int
	 * @return T
	 */
	public T get(final int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		T result = null;
		for (T item : this) {
			if (count == index) {
				result = item;
				break;
			}
			count++;
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		return new ElementsIterator();
	}

	/**
	 * Iterator.
	 */
	private class ElementsIterator implements Iterator<T> {
		/** Link to first Node. */
		private Node<T> nextItem;

		/** Link to last returned Node. */
		private Node<T> lastReturnedItem;

		/** Index of next Node. */
		private int nextIndex;

		/**
		 * Value of count when create iterator.
		 */
		private int expectedModCount;

		/**
		 * Constructor.
		 */
		private ElementsIterator() {
			this.nextItem = firstInList;
			this.lastReturnedItem = null;
			this.nextIndex = 0;
			this.expectedModCount = SimpleLinkedList.this.modCount;
			// END
		}

		@Override
		public boolean hasNext() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			boolean result = nextIndex < size;
			return result;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastReturnedItem = nextItem;
			nextItem = nextItem.getNextNode();
			nextIndex++;
			return lastReturnedItem.element;
		}
	}

	/**
	 * Node.
	 * @param <T> T
	 */
	private static class Node<T> {

		/** Element. */
		private T element;

		/** Link of next Node.*/
		private Node<T> nextNode;

		/** Link of previous Node.*/
		private Node<T> prevNode;

		/**
		 * Constructor.
		 * @param element T
		 * @param prevItem Node<T>
		 * @param nextItem Node<T>
		 */
		private Node(final T element, final Node<T> prevItem, final Node<T> nextItem) {
			this.element = element;
			this.nextNode = nextItem;
			this.prevNode = prevItem;
		}

		/**
		 * Getter to next Node.
		 * @return Node<T>
		 */
		public Node<T> getNextNode() {
			return nextNode;
		}
	}
}

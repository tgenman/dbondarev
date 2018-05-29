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
public class SimpleLinkedList<T> implements Iterable<T> {
	/** Link to first Node. */
	@GuardedBy("this")
	private Node<T> firstInList = null;

	/** Link to last Node. */
	@GuardedBy("this")
	private Node<T> lastInList = null;

	/** Size. */
	@GuardedBy("this")
	private int size;

	/** Counter of modifications. */
	private int modCount;

	/**
	 * Size.
	 * @return int size
	 */
	public synchronized int size() {
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
	public synchronized boolean add(final T newElement) {
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
	 * Remove by index.
	 * @param index int
	 * @return T
	 * @throws IndexOutOfBoundsException E
	 */
	public T remove(final int index) throws IndexOutOfBoundsException {
		ElementsIterator elementsIterator = new ElementsIterator(index);
		T temp = elementsIterator.next();
		elementsIterator.remove();
		this.modCount++;
		return temp;
	}

	/**
	 * Get by index.
	 * @param index int
	 * @return T
	 */
	public synchronized T get(final int index) {
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

	/**
	 * Contains.
	 * @param sample T
	 * @return boolean
	 */
	public boolean contains(T sample) {
		boolean result = false;
		for (T item: this) {
			if (item.equals(sample)) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		return new ElementsIterator();
	}

	/**
	 * Private method getItemByIndex.
	 * @param index int
	 * @return Node<T>
	 */
	private synchronized Node<T> getItemByIndex(final int index) {
		int i = 0;
		Node<T> current = firstInList;
		while (i != index) {
			current = current.nextNode;
			i++;
		}
		return current;
	}

	/**
	 * Private method to delete Node.
	 * @param current Node<T>
	 */
	private synchronized void remove(final Node<T> current) {
		if (current != null) {
			if (this.size() == 1) {
				this.firstInList = null;
				this.lastInList = null;
			} else {
				if (current == firstInList) {
					firstInList = current.nextNode;
					firstInList.prevNode = null;
				}
				if (current == lastInList) {
					lastInList = current.prevNode;
					lastInList.nextNode = null;
				}
				if (current.nextNode != null && current.prevNode != null) {
					current.prevNode.nextNode = current.nextNode;
					current.nextNode.prevNode = current.prevNode;
				}
			}
			size--;
		}
	}

	/**
	 * Iterator.
	 */
	@ThreadSafe
	private class ElementsIterator implements Iterator<T> {
		/** Link to first Node. */
		@GuardedBy("this")
		private Node<T> currentItemInIterator;

		/** Link to last returned Node. */
		@GuardedBy("this")
		private Node<T> lastReturnedItemFromIterator;

		/** Index of next Node. */
		@GuardedBy("this")
		private int index;

		/**
		 * Value of count when create iterator.
		 */
		private int expectedModCount;

		/**
		 * Constructor.
		 */
		private ElementsIterator() {
			this(0);
		}

		/**
		 * Constructor.
		 * @param index int
		 */
		private ElementsIterator(final int index) {
			if (index < 0 || index > size()) {
				throw new IndexOutOfBoundsException();
			}
			this.currentItemInIterator = (index == size) ? null : getItemByIndex(index);
			this.index = index;
			this.expectedModCount = SimpleLinkedList.this.modCount;
		}

		@Override
		public synchronized boolean hasNext() {
			synchronized (SimpleLinkedList.this) {
				if (this.expectedModCount != SimpleLinkedList.this.modCount) {
					throw new ConcurrentModificationException();
				}
				return this.index < size;
			}
		}

		@Override
		public synchronized T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastReturnedItemFromIterator = currentItemInIterator;
			currentItemInIterator = currentItemInIterator.getNextNode();
			index++;
			return lastReturnedItemFromIterator.element;
		}

		@Override
		public synchronized void remove() {
			if (lastReturnedItemFromIterator == null) {
				throw new IllegalStateException();
			}
			SimpleLinkedList.this.remove(lastReturnedItemFromIterator);
			lastReturnedItemFromIterator = null;
			index--;
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

		/**
		 * Getter to Previous Node.
		 * @return Node<T>
		 */
		public Node<T> getPrevNode() {
			return nextNode;
		}
	}
}

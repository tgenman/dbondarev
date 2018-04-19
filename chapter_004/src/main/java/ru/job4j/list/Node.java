package ru.job4j.list;

/**
 *  Created by tgenman on 4/19/18.
 * @param <T> T
 */
public class Node<T> {

	/** Element. */
	private T element;

	/** Link of next Node.*/
	private Node<T> nextNode;

	/**
	 * Constructor.
	 * @param element T
	 * @param nextNode Node<T>
	 */
	public Node(final T element, final Node<T> nextNode) {
		this.element = element;
		this.nextNode = nextNode;
	}

	/**
	 * Getter to next Node.
	 * @return Node<T>
	 */
	public Node<T> getNextNode() {
		return nextNode;
	}

	/**
	 * Getter Element.
	 * @return T
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Setter NextNode.
	 * @param link Node
	 */
	public void setNextNode(Node<T> link) {
		this.nextNode = link;
	}
}

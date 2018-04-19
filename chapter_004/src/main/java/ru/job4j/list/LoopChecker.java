package ru.job4j.list;

/**
 * Created by tgenman on 4/18/18.
 * @param <T> T
 */
public class LoopChecker<T> {
	/**
	 * Check sequence for loop.
	 * @param firstInList Node
	 * @return boolean
	 */
	public boolean hasCycle(Node<T> firstInList) {
		DynamicArray<Node<T>> buffer = new DynamicArray<>();
		for (Node<T> currentNode = firstInList; currentNode != null; currentNode = currentNode.getNextNode()) {
			System.out.println("element = " + currentNode.getElement());

			if (buffer.contains(currentNode)) {
				return true;
			}
			buffer.add(currentNode);
		}
		return false;
	}
}

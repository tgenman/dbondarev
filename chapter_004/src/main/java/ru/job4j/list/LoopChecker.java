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
		if (firstInList == null) return false;
		Node<T> turtle = firstInList;
		Node<T> hair = firstInList;
		while (true) {
			turtle = turtle.getNextNode();
			hair = hair.getNextNode();
			if (hair == null) return false;

			hair = hair.getNextNode();
			if (hair == null) return false;

			if (turtle == hair) return true;
		}
	}
}

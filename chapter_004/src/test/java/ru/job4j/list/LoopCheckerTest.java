package ru.job4j.list;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


/**
 * Created by tgenman on 4/18/18.
 */
public class LoopCheckerTest {

	/**
	 * Test 1.
	 */
	@Test
	public void testListHasLoopThenLoopHas() {
		final LoopChecker testInstance = new LoopChecker();
		Node<Integer> three = new Node<>(354345, null);
		Node<Integer> two = new Node<>(23345, three);
		Node<Integer> one = new Node<>(123, two);
		three.setNextNode(two);

		assertTrue(testInstance.hasCycle(one));
	}

	/**
	 * Test 2.
	 */
	@Test
	public void testListHasLoopThenLoopHasNot() {
		final LoopChecker testInstance = new LoopChecker();
		Node<Integer> three = new Node<>(354345, null);
		Node<Integer> two = new Node<>(23345, three);
		Node<Integer> one = new Node<>(123, two);

		assertFalse(testInstance.hasCycle(one));
	}
}
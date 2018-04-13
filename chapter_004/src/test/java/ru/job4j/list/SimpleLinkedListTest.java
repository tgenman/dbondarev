package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tgenman on 4/13/18.
 */
public class SimpleLinkedListTest {

	/**
	 * Test 1.
	 */
	@Test
	public void testSizeWhenSizeIs0()  {
		final SimpleLinkedList<Integer> testInstance = new SimpleLinkedList<>();
		assertEquals(0, testInstance.size());
	}

	/**
	 * Test 2.
	 */
	@Test
	public void testIsEmptyWhenEmpty()  {
		final SimpleLinkedList<Integer> testInstance = new SimpleLinkedList<>();
		assertTrue(testInstance.isEmpty());
	}

	/**
	 * Test 3.
	 */
	@Test
	public void testAdd()  {
		final SimpleLinkedList<Integer> testInstance = new SimpleLinkedList<>();
		testInstance.add(1);
		testInstance.add(1);
		assertEquals(2, testInstance.size());
		assertFalse(testInstance.isEmpty());
	}

	/**
	 * Test 4.
	 */
	@Test
	public void testGetInList() {
		final SimpleLinkedList<Integer> testInstance = new SimpleLinkedList<>();
		testInstance.add(1);
		testInstance.add(2);
		testInstance.add(3);
		assertThat(testInstance.get(0), is(1));
		assertThat(testInstance.get(1), is(2));
		assertThat(testInstance.get(2), is(3));
	}

	/**
	 * Test 5.
	 */
	@Test
	public void testGetInListOnException() {
		final SimpleLinkedList testInstance = new SimpleLinkedList<>();
		testInstance.add(1);
		testInstance.add(2);
		testInstance.add("trololo");
		try {
			testInstance.get(-25);
			fail("The set () method should throw an exception on the invalid inbound index!");
		} catch (Exception e) { }

		try {
			testInstance.get(3);
			fail("The set () method should throw an exception on the invalid inbound index!");
		} catch (Exception e) { }
	}

	/**
	 * Test 9.
	 * @throws Exception ConcurrentModificationException
	 */
	@Test
	public void testAddThenConcurrentModificateException() throws Exception {
		final SimpleLinkedList<Integer> testInstance = new SimpleLinkedList<>();
		testInstance.add(1);
		testInstance.add(2);
		Iterator<Integer> itr2 = testInstance.iterator();
		testInstance.add(3);
		try {
			itr2.next();
			fail("next do not throw the ConcurrentModificationException");
		} catch (final ConcurrentModificationException e) { }
	}
}
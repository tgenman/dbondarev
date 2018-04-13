package ru.job4j.list;


import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by tgenman on 4/13/18.
 */
public class DynamicArrayTest {
	/** Test Instance. */
	private final DynamicArray<Integer> testInstance = new DynamicArray<>();

	/**
	 * Test 1.
	 */
	@Test
	public void testSizeWhenSizeIs0() {
		assertEquals(0, testInstance.size());
	}

	/**
	 * Test 2.
	 */
	@Test
	public void testAdd()  {
		testInstance.add(1);
		testInstance.add(1);

		assertEquals(2, testInstance.size());
		assertFalse(testInstance.isEmpty());
	}

	/**
	 * Test 3.
	 */
	@Test
	public void testDeleteFirstElement() {
		testInstance.add(1);
		testInstance.add(2);
		testInstance.delete(1);

		assertEquals(1, testInstance.size());
		assertFalse(testInstance.isEmpty());
	}

	/**
	 * Test 4.
	 */
	@Test
	public void testDeleteLastElement() {
		testInstance.add(1);
		testInstance.add(2);
		testInstance.add(3);
		testInstance.delete(2);

		assertEquals(2, testInstance.size());
		assertFalse(testInstance.isEmpty());
	}

	/**
	 * Test 5.
	 */
	@Test
	public void testGet()  {
		testInstance.add(1);
		testInstance.add(2);
		testInstance.add(3);
		assertThat(testInstance.get(1), is(2));
	}

	/**
	 * Test 6.
	 */
	@Test
	public void testSet()  {
		testInstance.add(1);
		testInstance.add(2);
		testInstance.add(3);
		testInstance.set(1, 30);
		assertThat(testInstance.get(1), is(30));
	}

	/**
	 * Test 7.
	 */
	@Test
	public void testGetIndex()  {
		testInstance.add(1);
		testInstance.add(2);
		testInstance.add(30);
		assertThat(testInstance.getIndex(30), is(2));
	}

	/**
	 * Test 8.
	 * @throws Exception ConcurrentModificationException
	 */
	@Test
	public void testDeleteThenConcurrentModificateException() throws Exception {
		testInstance.add(1);
		testInstance.add(2);
		Iterator<Integer> itr2 = testInstance.iterator();
		testInstance.delete(0);
		try {
			itr2.next();
			fail("next do not throw the ConcurrentModificationException");
		} catch (final ConcurrentModificationException e) { }
	}

	/**
	 * Test 9.
	 * @throws Exception ConcurrentModificationException
	 */
	@Test
	public void testAddThenConcurrentModificateException() throws Exception {
		testInstance.add(1);
		testInstance.add(2);
		Iterator<Integer> itr2 = testInstance.iterator();
		testInstance.add(3);
		try {
			itr2.next();
			fail("next do not throw the ConcurrentModificationException");
		} catch (final ConcurrentModificationException e) { }
	}

	/**
	 * Test 10.
	 * @throws Exception NoSuchElementException
	 */
	@Test
	public void testWhenHaveNotElementForNextThenNoSuchElementException() throws Exception {
		testInstance.add(1);
		testInstance.add(2);
		Iterator<Integer> itr2 = testInstance.iterator();
		try {
			itr2.next();
			itr2.next();
			itr2.next();
			fail("next do not throw the NoSuchElementException");
		} catch (final NoSuchElementException e) { }
	}
}
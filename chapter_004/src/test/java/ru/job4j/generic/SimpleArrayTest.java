package ru.job4j.generic;

import org.junit.Test;


import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by tgenman on 4/12/18.
 */
public class SimpleArrayTest {

	/**
	 * Test 1.
	 */
	@Test
	public void testSizeWhenSizeIs0() {
		final SimpleArray<Integer> testInstance = new SimpleArray<>();
		assertEquals(0, testInstance.size());
	}

	/**
	 * Test 2.
	 */
	@Test
	public void testAdd()  {
		final SimpleArray<Integer> testInstance = new SimpleArray<>();
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
		final SimpleArray<Integer> testInstance = new SimpleArray<>();
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
		final SimpleArray<Integer> testInstance = new SimpleArray<>();
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
		final SimpleArray<Integer> testInstance = new SimpleArray<>();
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
		final SimpleArray<Integer> testInstance = new SimpleArray<>();
		testInstance.add(1);
		testInstance.add(2);
		testInstance.add(3);
		testInstance.set(1, 30);
		assertThat(testInstance.get(1), is(30));
	}

}
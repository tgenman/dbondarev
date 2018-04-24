package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by tgenman on 4/24/18.
 */
public class SimpleHashMapTest {
	/**
	 * Test 1.
	 */
	@Test
	public void whenInsertUniqueKeyThenReturnTrue() {
		SimpleHashMap<Integer, String> testInstance = new SimpleHashMap<>();
		testInstance.insert(7, "huge");
		assertTrue(testInstance.insert(5, "water"));
	}

	/**
	 * Test 2.
	 */
	@Test
	public void whenInsertNotUniqueKeyThenReturnFalse() {
		SimpleHashMap<Integer, String> testInstance = new SimpleHashMap<>();
		testInstance.insert(5, "water");
		testInstance.insert(7, "huge");
		assertFalse(testInstance.insert(5, "some"));
	}

	/**
	 * Test 3.
	 */
	@Test
	public void whenMapContainingKeyThenGetReturnValue() {
		SimpleHashMap<Integer, String> testInstance = new SimpleHashMap<>();
		testInstance.insert(5, "water");
		testInstance.insert(7, "huge");
		assertThat(testInstance.get(7), is("huge"));
	}

	/**
	 * Test 4.
	 */
	@Test
	public void whenMapNotContainingKeyThenGetReturnNull() {
		SimpleHashMap<Integer, String> testInstance = new SimpleHashMap<>();
		testInstance.insert(5, "water");
		testInstance.insert(7, "huge");
		assertTrue(testInstance.get(8) == null);
	}

	/**
	 * Test 5.
	 */
	@Test
	public void whenMapContainingKeyThenDeleteReturnTrue() {
		SimpleHashMap<Integer, String> testInstance = new SimpleHashMap<>();
		testInstance.insert(5, "water");
		testInstance.insert(7, "huge");
		assertTrue(testInstance.delete(5));
	}

	/**
	 * Test 6.
	 */
	@Test
	public void whenMapNotContainingKeyThenDeleteReturnFalse() {
		SimpleHashMap<Integer, String> testInstance = new SimpleHashMap<>();
		testInstance.insert(5, "water");
		testInstance.insert(7, "huge");
		assertFalse(testInstance.delete(8));
	}

}
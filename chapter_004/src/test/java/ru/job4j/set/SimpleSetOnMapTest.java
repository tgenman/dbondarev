package ru.job4j.set;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;

/**
 * Created by tgenman on 4/25/18.
 */
public class SimpleSetOnMapTest {


	/**
	 * Test 1.
	 */
	@Test
	public void whenAddUniqueItemThenSetHasThisItem() {
		final SimpleSetOnMap<Integer> testInstance = new SimpleSetOnMap<>();
		testInstance.add(5);
		testInstance.add(38);

		assertThat(testInstance.size(), is(2));
	}

	/**
	 * Test 2.
	 */
	@Test
	public void whenAddNotUniqueItemThenSHasSameSize() {
		final SimpleSetOnMap<Integer> testInstance = new SimpleSetOnMap<>();
		testInstance.add(5);
		testInstance.add(38);
		testInstance.add(38);

		assertThat(testInstance.size(), is(2));
	}

	/**
	 * Test 3.
	 */
	@Test
	public void whenSetContainsItem() {
		final SimpleSetOnMap<Integer> testInstance = new SimpleSetOnMap<>();
		testInstance.add(38);
		assertTrue(testInstance.contains(38));
	}

	/**
	 * Test 4.
	 */
	@Test
	public void whenSetNotContainsItem() {
		final SimpleSetOnMap<Integer> testInstance = new SimpleSetOnMap<>();
		testInstance.add(5);
		assertFalse(testInstance.contains(38));
	}

	/**
	 * Test 5.
	 */
	@Test
	public void whenSetContainsItemAndDelete() {
		final SimpleSetOnMap<Integer> testInstance = new SimpleSetOnMap<>();
		testInstance.add(38);
		testInstance.add(39);
		assertTrue(testInstance.remove(38));
	}

	/**
	 * Test 6.
	 */
	@Test
	public void whenSetNotContainsItemAndDelete() {
		final SimpleSetOnMap<Integer> testInstance = new SimpleSetOnMap<>();
		testInstance.add(38);
		testInstance.add(39);
		assertFalse(testInstance.remove(40));
	}
}
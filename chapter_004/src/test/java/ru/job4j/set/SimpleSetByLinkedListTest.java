package ru.job4j.set;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by tgenman on 4/19/18.
 */
public class SimpleSetByLinkedListTest {

	/**
	 * Test 1.
	 */
	@Test
	public void whenAddUniqueItemThenSetHasThisItem() {
		final SimpleSetByLinkedList<Integer> testInstance = new SimpleSetByLinkedList<>();
		testInstance.add(5);
		testInstance.add(38);

		assertThat(testInstance.size(), is(2));
		assertTrue(testInstance.contains(38));
	}

	/**
	 * Test 2.
	 */
	@Test
	public void whenAddNotUniqueItemThenSetHasSameSize() {
		final SimpleSetByLinkedList<Integer> testInstance = new SimpleSetByLinkedList<>();
		testInstance.add(5);
		testInstance.add(38);
		testInstance.add(38);

		assertThat(testInstance.size(), is(2));
	}
}
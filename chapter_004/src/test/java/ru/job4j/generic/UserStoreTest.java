package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tgenman on 4/12/18.
 */
public class UserStoreTest {
	/**
	 * Test 1.
	 */
	@Test
	public void testAdd()  {
		final UserStore testInstance = new UserStore();
		User one = new User("123");
		testInstance.add(one);

		assertThat(testInstance.findById("123").getId(), is(one.getId()));
	}

	/**
	 * Test 2.
	 */
	@Test
	public void testDelete()  {
		final UserStore testInstance = new UserStore();
		User one = new User("123");
		User two = new User("321");
		testInstance.add(one);
		testInstance.add(two);
		testInstance.delete("123");
		boolean result = testInstance.findById("123") == null;
		assertThat(result, is(true));
	}

	/**
	 * Test 2.
	 */
	@Test
	public void testReplace()  {
		final UserStore testInstance = new UserStore();
		User one = new User("123");
		User two = new User("321");
		testInstance.add(one);
		testInstance.replace("123", two);
		boolean result = testInstance.findById("123") == null;
		assertThat(result, is(true));
	}
}

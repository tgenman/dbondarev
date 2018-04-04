package ru.job4j.sort;


import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by tgenman on 4/4/18.
 */
public class UserTest {

	/**
	 * Test 1.
	 */
	@Test
	public void whenFirstUserNameEarlierThenReturnNegative() {
		User one = new User("Oleg", 17);
		User two = new User("Vasia", 25);
		boolean result = one.compareTo(two) < 0;
		assertThat(result, is(true));
	}

	/**
	 * Test 2.
	 */
	@Test
	public void whenFirstUserNameLaterThenReturnPositive() {
		User one = new User("Yandex", 17);
		User two = new User("Anton", 25);
		boolean result = one.compareTo(two) > 0;
		assertThat(result, is(true));
	}

	/**
	 * Test 3.
	 */
	@Test
	public void whenNameEqualsAndFirstAgeSmallerThenReturnNegative() {
		User one = new User("Anton", 17);
		User two = new User("Anton", 25);
		boolean result = one.compareTo(two) < 0;
		assertThat(result, is(true));
	}

	/**
	 * Test 3.
	 */
	@Test
	public void whenNameEqualsAndFirstAgeBiggerThenReturnPositive() {
		User one = new User("Anton", 32);
		User two = new User("Anton", 25);
		boolean result = one.compareTo(two) > 0;
		assertThat(result, is(true));
	}

	/**
	 * Test 5.
	 */
	@Test
	public void whenNameAndAgeEqualsThenReturnZero() {
		User one = new User("Anton", 17);
		User two = new User("Anton", 17);
		boolean result = one.compareTo(two) == 0;
		assertThat(result, is(true));
	}
}

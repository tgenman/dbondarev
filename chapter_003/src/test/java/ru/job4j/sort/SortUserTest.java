package ru.job4j.sort;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by tgenman on 4/4/18.
 */
public class SortUserTest {
	/**
	 * Test 1.
	 */
	@Test
	public void whenAddListThenReturnRightOrder() {
		User one = new User("Oleg", 35);
		User two = new User("Vasia", 12);
		User three = new User("Anna", 25);
		List<User> input = new ArrayList<>();
		input.add(one);
		input.add(two);
		input.add(three);
		SortUser sortUser = new SortUser();
		TreeSet<User> output =  (TreeSet<User>) sortUser.sort(input);
		assertThat(output.first().getAge(), is(12));
		assertThat(output.last().getAge(), is(35));
	}
}

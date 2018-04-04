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
	 * Test sort(List<User> list).
	 */
	@Test
	public void testSort() {
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

	/**
	 * Test sortNameLength(List<User> list).
	 */
	@Test
	public void testSortNameLength() {
		User one = new User("Oleg", 35);
		User two = new User("Vasiaa", 12);
		User three = new User("Annar", 25);
		List<User> input = new ArrayList<>();
		input.add(one);
		input.add(two);
		input.add(three);
		SortUser sortUser = new SortUser();
		List<User> output =  sortUser.sortNameLength(input);
		assertThat(output.get(0).getName(), is("Oleg"));
		assertThat(output.get(1).getName(), is("Annar"));
		assertThat(output.get(2).getName(), is("Vasiaa"));
	}

	/**
	 * Test sortByAllFields(List<User> list) .
	 */
	@Test
	public void testSortByAllFields() {
		User one = new User("Ivan", 30);
		User two = new User("Sergey", 25);
		User three = new User("Ivan", 25);
		User four = new User("Sergey", 20);
		List<User> input = new ArrayList<>();
		input.add(one);
		input.add(two);
		input.add(three);
		input.add(four);
		SortUser sortUser = new SortUser();
		List<User> output =  sortUser.sortByAllFields(input);
		assertThat(output.get(0).getName(), is("Ivan"));
		assertThat(output.get(0).getAge(), is(25));

		assertThat(output.get(1).getName(), is("Ivan"));
		assertThat(output.get(1).getAge(), is(30));

		assertThat(output.get(2).getName(), is("Sergey"));
		assertThat(output.get(2).getAge(), is(20));

		assertThat(output.get(3).getName(), is("Sergey"));
		assertThat(output.get(3).getAge(), is(25));
	}
}

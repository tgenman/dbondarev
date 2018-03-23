package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tgenman on 3/22/18.
 */
public class ConvertListTest {
	/**
	 * Test toList().
	 */
	@Test
	public void whenToListThenReturnRightList() {
		ConvertList convertList = new ConvertList();
		int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
		List<Integer> output = convertList.toList(input);
		assertThat(output.get(0), is(1));
		assertThat(output.get(1), is(2));
		assertThat(output.get(2), is(3));
		assertThat(output.get(3), is(4));
		assertThat(output.get(4), is(5));
		assertThat(output.get(5), is(6));
		assertThat(output.get(6), is(7));
		assertThat(output.get(7), is(0));
		assertThat(output.get(8), is(0));
	}

	/**
	 * Test toArray().
	 */
	@Test
	public void whenToArrayThenReturnRightArray() {
		ConvertList convertList = new ConvertList();
		List<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		input.add(6);
		input.add(7);
		input.add(8);
		input.add(9);
		input.add(10);
		int[][] output = convertList.toArray(input, 3);
		assertThat(output[0][0], is(1));
		assertThat(output[0][1], is(2));
		assertThat(output[0][2], is(3));
		assertThat(output[0][3], is(4));
		assertThat(output[1][0], is(5));
		assertThat(output[1][1], is(6));
		assertThat(output[1][2], is(7));
		assertThat(output[1][3], is(8));
		assertThat(output[2][0], is(9));
		assertThat(output[2][1], is(10));
		assertThat(output[2][2], is(0));
		assertThat(output[2][3], is(0));
	}
}

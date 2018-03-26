package ru.job4j.some;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by tgenman on 3/26/18.
 */
public class ArrayMergerTest {

	/**
	 * Test to mergeTwoSortedArrays.
	 */
	@Test
	public void whenInputTwoSortedArraysThenOutputMergedResultm() {
		ArraysMerger arraysMerger = new ArraysMerger();
		int[] one = new int[] {1, 5, 9};
		int[] two = new int[] {1, 2, 6, 11, 15};
		int[] expectedResult = new int[] {1, 1, 2, 5, 6, 9, 11, 15};
		int[] result = arraysMerger.mergeTwoSortedArrays(one, two);
		assertArrayEquals(result, expectedResult);
	}
}

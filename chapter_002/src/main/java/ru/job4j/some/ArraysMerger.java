package ru.job4j.some;

/**
 * Created by tgenman on 3/26/18.
 */
public class ArraysMerger {

	/**
	 * Merge two sorted arrays.
	 * @param one sorted array int[]
	 * @param two sorted array int[]
	 * @return sum array
	 */
	public int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];
		int indexOne = 0;
		int indexTwo = 0;
		for (int indexResult = 0; indexResult < result.length; indexResult++) {
			if ((indexOne != one.length)
					&& (one[indexOne] <= two[indexTwo])) {
				result[indexResult] = one[indexOne];
				indexOne++;
			} else {
				if (indexTwo != two.length) {
					result[indexResult] = two[indexTwo];
					indexTwo++;
				}
			}
		}
		return result;
	}
}

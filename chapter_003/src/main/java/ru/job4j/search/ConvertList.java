package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgenman on 3/22/18.
 */
public class ConvertList {

	/**
	 * Convert int[][] array to ArrayList.
	 * @param array input int[][] array
	 * @return List integers
	 */
	public List<Integer> toList(int[][] array) {
		List<Integer> result = new ArrayList<>();
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				result.add(array[x][y]);
			}
		}
		return result;
	}

	/**
	 * Convert List in int[][] array.
	 * @param list input List
	 * @param rows size of array
	 * @return int[][]
	 */
	public int[][] toArray(List<Integer> list, int rows) {
		int columns = (int) Math.ceil(list.size() * 1.00 / rows);
		int[][] result = new int[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				int indexOfList = r * columns + c;
				if (indexOfList >= list.size()) {
					result[r][c] = 0;
				} else {
					result[r][c] = list.get(indexOfList);
				}
			}
		}
		return result;
	}
}

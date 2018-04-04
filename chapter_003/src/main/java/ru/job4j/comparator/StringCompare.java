package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Created by tgenman on 4/4/18.
 */
public class StringCompare implements Comparator<String> {
	@Override
	public int compare(String left, String right) {
		int result;
		char[] one = left.toCharArray();
		char[] two = right.toCharArray();
		int lengthOne = left.length();
		int lengthTwo = right.length();
		int minLength = Math.min(lengthOne, lengthTwo);

		for (int index = 0; index < minLength; index++) {
			if (one[index] != two[index]) {
				return one[index] - two[index];
			}
		}
		return lengthOne - lengthTwo;
	}
}

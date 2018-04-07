package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for two dimension array.
 * Created by tgenman on 4/7/18.
 */
public class MatrixIterator implements Iterator<Integer> {

	private int[][] collection;

	private int outerIndex;

	private int innerIndex;

	public MatrixIterator(int[][] ints) {
		this.collection = ints;
		this.outerIndex = 0;
		this.innerIndex = 0;
	}

	@Override
	public boolean hasNext() {
		return outerIndex != collection.length && innerIndex != collection[outerIndex].length;
	}


	@Override
	public Integer next() {
		if (!hasNext()) throw new NoSuchElementException();
		if (innerIndex < collection[outerIndex].length - 1) {
			return collection[outerIndex][innerIndex++];
		} else {
			int old = innerIndex;
			innerIndex = 0;
			return collection[outerIndex++][old];
		}
	}
}

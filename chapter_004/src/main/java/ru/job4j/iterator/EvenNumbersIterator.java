package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for even numbers.
 * Created by tgenman on 4/7/18.
 */
public class EvenNumbersIterator implements Iterator<Integer> {

	private int[] collection;

	private int nextIndex;

	public EvenNumbersIterator(int[] ints) {
		this.collection = ints;
		for (int i = 0; i < collection.length; i++) {
			if (collection[i] % 2 == 0) {
				this.nextIndex = i;
				break;
			}
		}
	}

	@Override
	public boolean hasNext() {
		if (nextIndex == -1) return false;
		if (collection[nextIndex] % 2 == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		if (!hasNext()) throw new NoSuchElementException();
		int returnIndex = nextIndex;
		for (int i = nextIndex + 1; i < collection.length; i++) {
			if (collection[i] % 2 == 0) {
				nextIndex = i;
				break;
			}
		}
		if (returnIndex == nextIndex) nextIndex = -1;
		return collection[returnIndex];
	}
}

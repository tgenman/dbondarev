package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator fot Iterators
 * Created by tgenman on 4/7/18.
 */
public class Converter {

	Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
		return new Iterator<Integer>() {

			Iterator<Iterator<Integer>> iterators = it;

			Iterator<Integer> currentIterator = iterators.next();

			@Override
			public boolean hasNext() {
				if (currentIterator.hasNext()) return true;
				if (iterators.hasNext()) {
					currentIterator = iterators.next();
					if (currentIterator.hasNext()) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Integer next() {
				if (!hasNext()) throw new NoSuchElementException();
				if (currentIterator.hasNext()) {
					return currentIterator.next();
				} else {
					currentIterator = iterators.next();
					return currentIterator.next();
				}
			}
		};
	}
}

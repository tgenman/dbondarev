package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for prime numbers.
 * Created by tgenman on 4/7/18.
 */
public class PrimeIterator implements Iterator<Integer> {

	/** container. */
	private int[] collection;

	/** pointer.*/
	private int nextIndex = -1;

	/**
	 * Iterator for primes.
	 * @param ints int[]
	 */
	public PrimeIterator(int[] ints) {
		this.collection = ints;

		for (int i = 0; i < collection.length; i++) {
			System.out.println("construcor loop. i = " + i);
			if (this.isPrime(collection[i])) {
				this.nextIndex = i;
				break;
			}
		}
		System.out.println("End Constructor");
	}

	@Override
	public boolean hasNext() {
		if (nextIndex == -1) {
			return false;
		}
		if (this.isPrime(collection[nextIndex])) {
			return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		int returnIndex = nextIndex;
		for (int i = nextIndex + 1; i < collection.length; i++) {
			if (this.isPrime(collection[i])) {
				nextIndex = i;
				break;
			}
		}
		if (returnIndex == nextIndex) {
			nextIndex = -1;
		}
		return collection[returnIndex];
	}

	/**
	 * Checker fo primes.
	 * @param number int
	 * @return boolean
	 */
	private boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

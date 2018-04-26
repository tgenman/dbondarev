package ru.job4j.map;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by tgenman on 4/24/18.
 * @param <K> Key
 * @param <V> Value
 */
public class SimpleHashMap<K, V> {
	/** Size of table. */
	private int sizeOfTable = 100;
	/** Container of Buckets. */
	private Object[] containerOfBuckets =  new Object[sizeOfTable];
	/** Amount elements in map. */
	private int countOfElements = 0;
	/** Coefficient to increasing map. */
	private static final double COEFFICIENT_OF_CAPACITY_MAP = 0.75;
	/** Rate of increasing map. */
	private static final int RATE_OF_INCREASING_MAP = 2;

	/**
	 * Size.
	 * @return int
	 */
	public int size() {
		return countOfElements;
	}

	/**
	 * Insert.
	 * @param key K
	 * @param value V
	 * @return boolean result of inserting.
	 */
	public boolean insert(K key, V value) {
		boolean result = false;
		if (containerOfBuckets[getNumberOfBucket(key)] == null) {
			containerOfBuckets[getNumberOfBucket(key)] = new Pair(key, value);
			result = true;
			countOfElements++;
			checkNeedOfIncreaseMap();
		}
		return result;
	}

	/**
	 * Get Value by key.
	 * @param key K
	 * @return V
	 */
	public V get(K key) {
		if (key == null) return null;
		V result = null;
		if (containerOfBuckets[getNumberOfBucket(key)] != null) {
			result = ((Pair) containerOfBuckets[getNumberOfBucket(key)]).getValue();
		}
		return result;
	}

	/**
	 * delete.
	 * @param key K
	 * @return boolean
	 */
	public boolean delete(K key) {
		boolean result = false;
		if (key == null) return false;
		if (containerOfBuckets[getNumberOfBucket(key)] != null) {
			containerOfBuckets[getNumberOfBucket(key)] = null;
			result = true;
		}
		return result;
	}

	/**
	 * Contains.
	 * @param key K
	 * @return boolean
	 */
	public boolean contains(K key) {
		if (key == null) return false;
		Iterator<Pair> iterator = this.iterator();
		while (iterator.hasNext()) {
			if (key.equals(iterator.next().getKey())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get numbers of bucket.
	 * @param key K
	 * @return int
	 */
	private int getNumberOfBucket(K key) {
		return (int) key.hashCode() % sizeOfTable;
	}

	/**
	 * Check needs to increase map.
	 */
	private void checkNeedOfIncreaseMap() {
		if (sizeOfTable % countOfElements >= COEFFICIENT_OF_CAPACITY_MAP) {
			increaseContainerOfBuckets();
		}
	}

	/**
	 * Increase containerOfBuckets.
	 */
	private void increaseContainerOfBuckets() {
		sizeOfTable = sizeOfTable * RATE_OF_INCREASING_MAP;
		Object[] buffer =  new Object[sizeOfTable];
		for (int i = 0; i < containerOfBuckets.length; i++) {
			buffer[i * 2] = containerOfBuckets[i];
		}
		containerOfBuckets = buffer;
	}

	/**
	 * Iterator.
	 * @return iterator
	 */
	public Iterator<Pair> iterator() {
		return new MapIterator<Pair>();
	}

	/**
	 * MapIterator.
	 * @param <E>
	 */
	private class MapIterator<E> implements Iterator<E> {

		/** nextIndex. */
		private int nextIndex;
		/** last returned. */
		private int lastReturned = -1;

		/**
		 * Constructor.
		 */
		MapIterator() {
			this.nextIndex = -1;
			for (int i = 0; i < sizeOfTable; i++) {
				if (containerOfBuckets[i] != null) {
					this.nextIndex = i;
				}
			}
		}

		@Override
		public boolean hasNext() {
			return nextIndex != -1;
		}

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			this.lastReturned = this.nextIndex;
			E result = (E) containerOfBuckets[nextIndex];
			this.nextIndex = -1;
			for (int i = lastReturned + 1; i < sizeOfTable; i++) {
				if (containerOfBuckets[i] != null) {
					this.nextIndex = i;
				}
			}
			return result;
		}
	}

	/**
	 * Pair class.
	 */
	private class Pair implements Map.Entry<K, V> {
		/** key. */
		private final K key;
		/** Value. */
		private V value;

		/**
		 * Pair.
		 * @param key K
		 * @param value V
		 */
		private Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Getter Key.
		 * @return Key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * Getter Value.
		 * @return Value
		 */
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			final V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;

			Map.Entry<K, V> pair = (Map.Entry<K, V>) o;


			if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
			return !(value != null ? !value.equals(pair.getValue()) : pair.getValue() != null);

		}

		@Override
		public int hashCode() {
			return (key   == null ? 0 :   key.hashCode())
					^ (value == null ? 0 : value.hashCode());
		}
	}
}

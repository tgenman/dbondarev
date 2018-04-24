package ru.job4j.map;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by tgenman on 4/24/18.
 * @param <K> Key
 * @param <V> Value
 */
public class SimpleHashMap<K, V> implements Iterable<K> {

	private int sizeOfTable = 100;
	private Pair<K, V>[] containerOfBuckets = new Pair[sizeOfTable];
	private int countOfElements = 0;
	private final static double COEFFICIENT_OF_CAPACITY_MAP = 0.75;
	private final static int COEFFICIENT_OF_INCREASING_MAP = 2;

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

	public V get(K key) {
		if (key == null) return null;
		for (int i = 0; i < sizeOfTable; i++) {
			if (containerOfBuckets[i] != null
					&& key.equals(containerOfBuckets[i].getKey())) {
				return containerOfBuckets[i].getValue();
			}
		}
		return null;
	}

	public boolean delete(K key) {
		boolean result = false;
		if (key == null) return false;
		for (int i = 0; i < sizeOfTable; i++) {
			if (containerOfBuckets[i] != null
					&& key.equals(containerOfBuckets[i].getKey())) {
				containerOfBuckets[i] = null;
				result = true;
				break;
			}
		}
		return result;
	}

	private int getNumberOfBucket(K key) {
		return (int) key.hashCode() % sizeOfTable;
	}

	private void checkNeedOfIncreaseMap() {
		if (sizeOfTable % countOfElements >= COEFFICIENT_OF_CAPACITY_MAP) {
			increaseContainerOfBuckets();
		}
	}

	private void increaseContainerOfBuckets() {
		sizeOfTable = sizeOfTable * COEFFICIENT_OF_INCREASING_MAP;
		Pair[] buffer = new Pair[sizeOfTable];
		for (int i = 0; i < containerOfBuckets.length; i++) {
			buffer[i * 2] = containerOfBuckets[i];
		}
		containerOfBuckets = buffer;
	}

	@Override
	public Iterator<K> iterator() {
		return new MapIterator<>();
	}


	private class MapIterator<K> implements Iterator<K> {

		private int nextIndex;
		private int lastReturned = -1;

		public MapIterator() {
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
		public K next() {
			if (!hasNext()) throw new NoSuchElementException();
			this.lastReturned = this.nextIndex;
			K result = (K) containerOfBuckets[nextIndex].getKey();
			this.nextIndex = -1;
			for (int i = lastReturned + 1; i < sizeOfTable; i++) {
				if (containerOfBuckets[i] != null) {
					this.nextIndex = i;
				}
			}
			return result;
		}
	}


	private class Pair<K, V> implements Map.Entry<K, V> {

		private final K key;

		private V value;

		private Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

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
			return (key   == null ? 0 :   key.hashCode()) ^
					(value == null ? 0 : value.hashCode());
		}
	}
}

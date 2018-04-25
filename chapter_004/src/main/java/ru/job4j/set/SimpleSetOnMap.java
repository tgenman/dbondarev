package ru.job4j.set;

import ru.job4j.map.SimpleHashMap;

/**
 * Created by tgenman on 4/25/18.
 * @param <T> T
 */
public class SimpleSetOnMap<T> {
	/** Container. */
	private SimpleHashMap<T, Object> container = new SimpleHashMap<>();

	/**
	 * Size.
	 * @return int size
	 */
	public int size() {
		return container.size();
	}

	/**
	 * Add.
	 * @param e T
	 * @return boolean
	 */
	public boolean add(T e) {
		boolean result = false;
		if (!container.contains(e)) {
			container.insert(e, null);
			result = true;
		}
		return result;
	}

	/**
	 * Contains.
	 * @param e T
	 * @return boolean
	 */
	public boolean contains(T e) {
		return container.contains(e);
	}

	/**
	 * Remove.
	 * @param e T
	 * @return boolean
	 */
	public boolean remove(T e) {
		return container.delete(e);
	}



}

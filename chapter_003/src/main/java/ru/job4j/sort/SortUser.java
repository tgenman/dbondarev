package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by tgenman on 4/3/18.
 */
public class SortUser {

	/**
	 * Container with Comparator.
	 */
	private Set<User> container = new TreeSet<>(
			new Comparator<User>() {
				@Override
				public int compare(User o1, User o2) {
					Integer wrapAgeUser = o1.getAge();
					return wrapAgeUser.compareTo(o2.getAge());
				}
			}
	);

	/**
	 * Method sort.
	 * @param list List
	 * @return TreeSet
	 */
	public Set<User> sort(List<User> list) {
		this.container.addAll(list);
		return this.container;
	}
}

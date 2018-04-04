package ru.job4j.sort;

import java.util.*;

/**
 * Created by tgenman on 4/3/18.
 */
public class SortUser {

	/**
	 * Container with Comparator.
	 */
	private Set<User> container;

	/**
	 * Method sort.
	 * @param list List
	 * @return TreeSet
	 */
	public Set<User> sort(List<User> list) {
		this.container = new TreeSet<>(
				new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						Integer wrapAgeUser = o1.getAge();
						return wrapAgeUser.compareTo(o2.getAge());
					}
				}
		);
		this.container.addAll(list);
		return this.container;
	}

	public List<User> sortNameLength(List<User> list) {
		this.container = new TreeSet<>(
				new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						Integer lengthNameO1= o1.getName().length();
						Integer lengthNameO2= o2.getName().length();
						return lengthNameO1.compareTo(lengthNameO2);
					}
				}
		);
		this.container.addAll(list);
		List<User> result = new ArrayList<>();
		for (User user : this.container) {
			result.add(user);
		}
		return result;
	}

	public List<User> sortByAllFields(List<User> list) {
		this.container = new TreeSet<>();
		this.container.addAll(list);
		List<User> result = new ArrayList<>();
		for (User user : this.container) {
			result.add(user);
		}
		return result;
	}
}

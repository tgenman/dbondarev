package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

/**
 * Created by tgenman on 3/23/18.
 */
public class UserConvert {

	/**
	 * Convert.
	 * @param list Users
	 * @return HashMap Integer, User
	 */
	public HashMap<Integer, User> process(List<User> list) {
		HashMap<Integer, User> result = new HashMap<>();
		for (User user: list) {
			result.put(user.getId(), user);
		}
		return result;
	}
}

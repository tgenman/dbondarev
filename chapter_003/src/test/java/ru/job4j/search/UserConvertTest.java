package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by tgenman on 3/23/18.
 */
public class UserConvertTest {
	/**
	 * Test process(List<User>).
	 */
	@Test
	public void whenProcessThenReturnRightMap() {
		UserConvert userConvert = new UserConvert();
		List<User> users = new ArrayList<>();
		users.add(new User(1,"Ivan", "Piter"));
		users.add(new User(2,"Petr", "Sochi"));
		users.add(new User(3,"Stas", "Moscow"));
		Map<Integer, User> result =  userConvert.process(users);
		assertThat(result.containsKey(1), is(true));
		assertThat(result.containsKey(2), is(true));
		assertThat(result.containsKey(3), is(true));
	}
}

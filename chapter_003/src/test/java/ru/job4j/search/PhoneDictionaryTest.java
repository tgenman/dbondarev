package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tgenman on 3/22/18.
 */
public class PhoneDictionaryTest {
	/**
	 * Test.
	 */
	@Test
	public void whenFindByName() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev", "534872", "Bryansk")
		);
		List<Person> persons = phones.find("Petr");
		System.out.println("1");
		assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
	}
}

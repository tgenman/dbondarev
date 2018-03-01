package ru.job4j.start;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author tgenman
 */
public class StartUITest {
	/**
	 * Test to use "0. Add new item".
	 */
	@Test
	public void whenUserAddItemThenTrackerHasSameItemWithSameName() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getName(), is("test name"));
	}

	/**
	 * Test to use "2. Edit item".
	 */
	@Test
	public void whenUpdateThenTrackerHasSameUpdateValue() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item());
		Input input = new StubInput(new String[] {"2", item.getId(), "test name", "desc", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getName(), is("test name"));
	}

	/**
	 * Test to use "3. Delete item".
	 */
	@Test
	public void whenDeleteItemThenTrackerHasItem() {
		Tracker tracker = new Tracker();
		Item item1 = tracker.add(new Item("test1", "description1"));
		tracker.add(new Item("test2", "description2"));
		Input input = new StubInput(new String[] {"3", item1.getId(), "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getName(), is("test2"));
	}
}

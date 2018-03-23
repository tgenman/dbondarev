package ru.job4j.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author tgenman
 */
public class StartUITest {
	/** Default stdout. */
	private final PrintStream stdout = System.out;
	/** Test stdout. */
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	/** Choose line separator. */
	private final String line = System.getProperty("line.separator");

	/**
	 * to test print menu.
	 */
	private final String menu = new StringBuilder()
			.append("Меню").append(line)
			.append("0. Add new item").append(line)
			.append("1. Show all items").append(line)
			.append("2. Edit item").append(line)
			.append("3. Delete item").append(line)
			.append("4. Find item by id").append(line)
			.append("5. Find items by name").append(line)
			.append("6. Exit program").append(line)
			.toString();

	/**
	 * Change stdout.
	 */
	@Before
	public void loadOutput() {
		System.setOut(new PrintStream(this.out));
	}

	/**
	 * Return stdout.
	 */
	@After
	public void backOutput() {
		System.setOut(this.stdout);
	}

	/**
	 * Test to use "0. Add new item".
	 */
	@Test
	public void whenUserAddItemThenTrackerHasSameItemWithSameName() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll().get(0).getName(), is("test name"));
	}

	/**
	 * Test to use "1. Show all items".
	 */
	@Test
	public void whenUserShowAllItems() {
		Tracker tracker = new Tracker();
		Item item = new Item("test name", "desc");
		tracker.add(item);
		Input input = new StubInput(new String[] {"1", "6"});
		new StartUI(input, tracker).init();
		assertThat(new String(out.toByteArray()), is(
						new StringBuilder()
								.append(menu)
								.append("---------- Показать все заявки: ---------").append(line)
								.append("Name: test name Description: desc id: ").append(item.getId()).append(line)
								.append(menu)
								.toString()
				));
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
		assertThat(tracker.findAll().get(0).getName(), is("test name"));
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
		assertThat(tracker.findAll().get(0).getName(), is("test2"));
	}

	/**
	 * Test to use "4. Find item by id".
	 */
	@Test
	public void whenUserFindItemById() {
		Tracker tracker = new Tracker();
		Item item = new Item("test name", "desc");
		tracker.add(item);
		Input input = new StubInput(new String[] {"4", item.getId(), "6"});
		new StartUI(input, tracker).init();
		assertThat(new String(out.toByteArray()), is(
				new StringBuilder()
						.append(menu)
						.append("---------- Поиск заявки по id ---------").append(line)
						.append("Name: test name Description: desc id: ").append(item.getId()).append(line)
						.append(menu)
						.toString()
		));
	}

	/**
	 * Test to use "5. Find item by Name".
	 */
	@Test
	public void whenUserFindItemByName() {
		Tracker tracker = new Tracker();
		Item item = new Item("test name", "desc");
		tracker.add(item);
		Input input = new StubInput(new String[] {"5", "test name", "6"});
		new StartUI(input, tracker).init();
		assertThat(new String(out.toByteArray()), is(
				new StringBuilder()
						.append(menu)
						.append("---------- Поиск заявки по имени ---------").append(line)
						.append("Name: test name Description: desc id: ").append(item.getId()).append(line)
						.append(menu)
						.toString()
		));
	}
}

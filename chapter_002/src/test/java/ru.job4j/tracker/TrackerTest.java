package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerTest {
    /**
     * Test to use Add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Test to use Replace.
     */
    @Test
    public void whenRepalceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        previous.print();
        tracker.add(previous);
		previous.print();
        Item next = new Item("test2", "testDescription2", 1234L);
        next.print();
        tracker.replace(previous.getId(), next);
        next.print();
        assertThat(tracker.findById(next.getId()).getName(), is("test2"));
    }

    /**
     * Test to use Find by Id.
     */
    @Test
    public void whenFindByIdReturnRightElement() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1", "testDescription1", 123L));
        tracker.add(new Item("test2", "testDescription2", 123L));
        tracker.add(new Item("test3", "testDescription3", 123L));
        String keyId = tracker.findAll().get(1).getId();
        assertThat(tracker.findById(keyId).getId(), is(keyId));
    }

    /**
     * Test to use Find by Name.
     */
    @Test
    public void whenFindByNameReturnRightElement() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1", "testDescription1", 123L));
        tracker.add(new Item("test2", "testDescription2", 123L));
        tracker.add(new Item("test3", "testDescription3", 123L));
        String keyName = "test2";
        for (Item item : tracker.findByName("test2")) {
            assertThat(item.getName(), is(keyName));
        }
    }

    /**
     * Test to use Delete.
     */
    @Test
    public void whenDeleteReturnArrayWithoutElement() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1", "testDescription1", 123L);
        Item itemToDelete = new Item("test2", "testDescription2", 123L);
        Item three = new Item("test3", "testDescription3", 123L);
        Item four = new Item("test4", "testDescription4", 123L);
        tracker.add(one);
        tracker.add(itemToDelete);
        tracker.add(three);
        tracker.add(four);
        tracker.delete(itemToDelete.getId());
        Item expectedResult = null;
        assertThat(tracker.findById(itemToDelete.getId()), is(expectedResult));
    }

    /**
     * Test to use Find All.
     */
    @Test
    public void whenFindAllReturnAllNotNullElements() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1", "testDescription1", 123L);
        Item two = new Item("test2", "testDescription2", 123L);
        tracker.add(one);
        tracker.add(two);
        List<Item> expectArray = new ArrayList<>();
        expectArray.add(one);
        expectArray.add(two);
        List<Item> resultArray = tracker.findAll();
        for (int i = 0; i < 2; i++) {
            assertThat(resultArray.get(i), is(expectArray.get(i)));
        }
    }
}

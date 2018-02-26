package java.ru.job4j.start;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.models.Task;
import ru.job4j.start.Tracker;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerTest {
    /**
     * Test to use Update.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Task("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Task("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.update(next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test to use Add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test to use Find by Id.
     */
    @Test
    public void whenFindByIdReturnRightElement() {
        Tracker tracker = new Tracker();
        tracker.add(new Task("test1", "testDescription1", 123L));
        tracker.add(new Task("test2", "testDescription2", 123L));
        tracker.add(new Task("test3", "testDescription3", 123L));
        String keyId = tracker.findAll()[1].getId();
        assertThat(tracker.findById(keyId).getId(), is(keyId));
    }

    /**
     * Test to use Find by Name.
     */
    @Test
    public void whenFindByNameReturnRightElement() {
        Tracker tracker = new Tracker();
        Task some = new Task("test2", "testDescription2", 123L);
        Task[] result = {some};
        tracker.add(new Task("test1", "testDescription1", 123L));
        tracker.add(some);
        tracker.add(new Task("test3", "testDescription3", 123L));
        String keyName = "test2";
//        for (Item item : tracker.findByName("test2")) {
//            System.out.println(item.getName());
//            assertThat(item.getName(), is(keyName));
//        }
        assertThat(tracker.findByName("test2"), is(result));
    }

    /**
     * Test to use Find All.
     */
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        tracker.add(new Task("test1", "testDescription1", 123L));
        tracker.add(new Task("test2", "testDescription2", 123L));
        tracker.add(new Task("test3", "testDescription3", 123L));
        Item[] expectArray = new Item[3];
        expectArray[0] = new Task("test1", "testDescription1", 123L);
        expectArray[1] = new Task("test2", "testDescription2", 123L);
        expectArray[2] = new Task("test3", "testDescription3", 123L);
        assertThat(tracker.findAll(), arrayContainingInAnyOrder(expectArray));
    }
}

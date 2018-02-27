package ru.job4j.tracker;

import ru.job4j.models.Item;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /** Array to Items. */
    private Item[] items = new Item[100];
    /** Pointer to first free index in Item's Array. */
    private int position = 0;
    /** Instance to generate random numbers. */
    private static final Random RN = new Random();

    /**
     * Adding Item in Tracker.
     * @param item Item to adding.
     * @return Item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Replace item in Tracker by item's id.
     * @param item Item
     */
    public void replace(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
            }
        }
    }

    /**
     * Delete item by id.
     * And replace right part of array.
     * @param id items's id
     */
    public void delete(String id) {
//        Item[] buffer = new Item[100];
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, (index + 1), this.items, index, (this.position - index - 1));
                this.position--;
//                items = buffer;
                break;
            }
//            buffer[index] = items[index];
        }
    }

    /**
     * Return all Items.
     * @return Item[] without nulls
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Find all Items with name and return array of them.
     * @param name Name of item
     * @return Item[] with the name.
     */
    public Item[] findByName(String name) {
        Item[] resultItems = new Item[this.items.length];
        int innerPosition = 0;
        for (int index = 0; index < this.position; index++) {
            if (items[index].getName().equals(name)) {
                resultItems[innerPosition++] = items[index];
            }
        }
        return Arrays.copyOf(resultItems, innerPosition);
    }

    /**
     * Find item by Id.
     * @param id String of id
     * @return Item with this id
     */
    public Item findById(String id) {
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Generation id.
     * @return String of id
     */

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}

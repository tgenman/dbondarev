package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /** ArrayList to Items. */
    private List<Item> items = new ArrayList<>();
    /** Instance to generate random numbers. */
    private static final Random RN = new Random();

    /**
     * Adding Item in Tracker.
     * @param item Item to adding.
     * @return Item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Replace item in Tracker by item's id.
     * @param id String id of old Item
     * @param item new Item
     */
    public void replace(String id, Item item) {
        int index = -1;
        for (Item itemLoop: this.items) {
            if (itemLoop.getId().equals(id)) {
                item.setId(this.generateId());
                index = this.items.indexOf(itemLoop);
            }
        }
        if (index != -1) {
            this.items.set(index, item);
        }
//        for (int index = 0; index < this.position; index++) {
//            if (this.items[index].getId().equals(id)) {
//                item.setId(this.generateId());
//                this.items[index] = item;
//            }
//        }
    }

    /**
     * Delete item by id.
     * And replace right part of array.
     * @param id items's id
     */
    public void delete(String id) {
        int index = -1;
        for (Item itemLoop: this.items) {
            if (itemLoop.getId().equals(id)) {
                index = this.items.indexOf(itemLoop);
            }
        }
        if (index != -1) {
            this.items.remove(index);
        }

//        for (int index = 0; index < position; index++) {
//            if (this.items[index].getId().equals(id)) {
//                System.arraycopy(this.items, (index + 1), this.items, index, (this.position - index - 1));
//                this.position--;
//                break;
//            }
//        }
    }

    /**
     * Return all Items.
     * @return Item[] without nulls
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Find all Items with name and return array of them.
     * @param name Name of item
     * @return Item[] with the name.
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item: this.items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;

//        int innerPosition = 0;
//        for (int index = 0; index < this.position; index++) {
//            if (items[index].getName().equals(name)) {
//                resultItems[innerPosition++] = items[index];
//            }
//        }
//        return Arrays.copyOf(resultItems, innerPosition);
    }

    /**
     * Find item by Id.
     * @param key String of id
     * @return Item with this id
     */
    public Item findById(String key) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(key)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Generation id.
     * @return String of id
     */

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}

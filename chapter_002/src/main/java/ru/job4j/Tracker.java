package ru.job4j;

import ru.job4j.Item;

import java.util.Arrays;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;


    public Item add(Item item) {
        this.items[position++] = item;
        return item;
    }

    public void update(Item item) {
        for (int index = 0; index <= this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
            }
        }
    }

    public void delete(Item item) {

    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    public Item[] findByName(String name) {
        return this.items;
    }

    public Item findById(String id) {
        for (int index = 0; index <= this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                return this.items[index];
            }
        }
        return null;
    }
}

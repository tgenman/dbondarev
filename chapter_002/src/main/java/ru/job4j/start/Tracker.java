package ru.job4j.start;

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
     * Changing item in Tracker by item's id.
     * @param item Item
     */
    public void update(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
            }
        }
    }


//    public void delete(Item item) {
//        for (int index = 0; index < position; index++) {
//            if (items[index].getId().equals(item.getId())) {
//                items[index] = null;
//                items[index] = items[position - 1];
//                items[position - 1] = null;
//                position--;
//                break;
//            }
//        }
//    }

//    public Item[] findAll() {
//        return Arrays.copyOf(this.items, position);
//    }


//    public Item[] findByName(String name) {
//        Item[] inner = new Item[this.items.length];
//        int innerIndex = 0;
//        for (int index = 0; index < innerIndex; index++) { !!!!!!!!!!!
//            if (items[index].getName().equals(name)) {
//                inner[innerIndex] = items[index];
//                innerIndex++;
//            }
//        }
//        return Arrays.copyOf(inner, innerIndex);
//    }

    /**
     * Find item by Id.
     * @param id String of id
     * @return Item with this id
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
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

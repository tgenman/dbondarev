package ru.job4j.models;

/**
 * Task class.
 * Extends Item.
 */
public class Task extends Item {
    /**
     * Constructor.
     * @param name String
     * @param description String
     * @param create long
     */
    public Task(String name, String description, long create) {
        super(name, description, create);
    }
}

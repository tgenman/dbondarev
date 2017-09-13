package ru.job4j.models;

public class Task extends Item {

    public Task(String name, String description, long create) {
        this.name = name;
        this.desc = description;
        this.create = create;
    }
}

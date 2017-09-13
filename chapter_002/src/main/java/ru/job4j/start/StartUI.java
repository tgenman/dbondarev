package ru.job4j.start;

import ru.job4j.models.*;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        String name = input.ask("Please, enter the task's name");
        Tracker tracker = new Tracker();
        tracker.add(new Task(name, "first desc", 123l));
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        };
    }

    /*public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }*/
}

package ru.job4j.start;

//import ru.job4j.models.Item;
//import ru.job4j.tracker.Tracker;

/**
 * Start User Interface.
 * @author tgenman
 */
public class StartUI {
    /** Contain realisation of input. */
    private Input input;

    /**
     * Constructor.
     * @param input Instance of Input interface
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Start.
     */
//    public void init() {
//        String name = input.ask("Please, enter the task's name");
//        Tracker tracker = new Tracker();
//        tracker.add(new Task(name, "first desc", 123L));   //Зачем Task?
//        for (Item item : tracker.findAll()) {
//            System.out.println(item.getName());
//        }
//    }

//    public static void main(String[] args) {
//        Input input = new ConsoleInput();
//        new StartUI(input).init();
//    }
}

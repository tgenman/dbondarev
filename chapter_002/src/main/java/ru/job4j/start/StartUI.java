package ru.job4j.start;

import ru.job4j.tracker.MenuTracker;
import ru.job4j.tracker.Tracker;

/**
 * Start User Interface.
 * @author tgenman
 */
public class StartUI {
    /** Constanta for menu to add new Item. */
    private static final String ADD = "0";
    /** Constanta for menu to show all items. */
    private static final String SHOWALL = "1";
    /** Constanta for menu to edit Item. */
    private static final String EDIT = "2";
    /** Constanta for menu to delete Item. */
    private static final String DELETE = "3";
    /** Constanta for menu to find Item by Id. */
    private static final String FINDITEMBYID = "4";
    /** Constanta for menu to find item by name. */
    private static final String FINDITEMBYNAME = "5";
    /** Constanta for menu to exit. */
    private static final String EXIT = "6";

    /** Realisation of input. */
    private final Input input;
    /** Container to Items. */
    private final Tracker tracker;

    /**
     * Constructor.
     * @param input Instance of Input interface
     * @param tracker Instance of container to Items
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * main loop of program.
     */
    public void init() {
        boolean exit = false;
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		menu.fillActions();
        while (!exit) {
            menu.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            exit = this.checkUserInput(answer, menu);
        }
    }

	/**
	 * Chech User's input and execute Action of Menu.
	 * @param answer user's input
	 * @param menu instance of MenuTracker to exeucte actions
	 * @return boolean to repeat loop of program
	 */
    public boolean checkUserInput(String answer, MenuTracker menu) {
    	String[] flagsOfMenu = new String[] {ADD, SHOWALL, EDIT, DELETE, FINDITEMBYID, FINDITEMBYNAME};
    	boolean result = false;
    	for (int index = 0; index < 6; index++) {
			if (answer.equals(flagsOfMenu[index])) {
				menu.select(Integer.parseInt(flagsOfMenu[index]));
				result = false;
			}
		}
		if (answer.equals(EXIT)) {
			result = true;
		}
		return result;
	}

    /**
     * Point ro start program.
     * @param args nothing
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

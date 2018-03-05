package ru.job4j.start;

import ru.job4j.tracker.MenuTracker;
import ru.job4j.tracker.Tracker;

/**
 * Start User Interface.
 * @author tgenman
 */
public class StartUI {
	/** Container to range */
	private int[] range = new int[] {ADD, SHOWALL, EDIT, DELETE, FINDITEMBYID, FINDITEMBYNAME, EXIT};
    /** Constainer for menu to add new Item. */
    private static final int ADD = 0;
    /** Container for menu to show all items. */
    private static final int SHOWALL = 1;
    /** Constainer for menu to edit Item. */
    private static final int EDIT = 2;
    /** Constainer for menu to delete Item. */
    private static final int DELETE = 3;
    /** Constainer for menu to find Item by Id. */
    private static final int FINDITEMBYID = 4;
    /** Constainer for menu to find item by name. */
    private static final int FINDITEMBYNAME = 5;
    /** Constainer for menu to exit. */
    private static final int EXIT = 6;

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
            int answer = this.input.ask("Введите пункт меню: ", this.range);
            exit = this.checkUserInput(answer, menu);
        }
    }

	/**
	 * Chech User's input and execute Action of Menu.
	 * @param answer user's input
	 * @param menu instance of MenuTracker to exeucte actions
	 * @return boolean to repeat loop of program
	 */
    public boolean checkUserInput(int answer, MenuTracker menu) {
    	int[] flagsOfMenu = new int[] {ADD, SHOWALL, EDIT, DELETE, FINDITEMBYID, FINDITEMBYNAME};
    	boolean result = false;
		if (answer == EXIT) {
			result = true;
		}
		for (int index = 0; index < (this.range.length - 1); index++) {
			if (answer == flagsOfMenu[index]) {
				menu.select(flagsOfMenu[index]);
				result = false;
			}
		}
		return result;
	}

    /**
     * Point ro start program.
     * @param args nothing
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}

package ru.job4j.start;


import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
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
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDITEMBYID.equals(answer)) {
                this.findItemByID();
            } else if (FINDITEMBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

	/**
	 * Print all Menu for User.
	 */
	private void showMenu() {
		System.out.println("Меню");
		System.out.println("0. Add new item");
		System.out.println("1. Show all items");
		System.out.println("2. Edit item");
		System.out.println("3. Delete item");
		System.out.println("4. Find item by id");
		System.out.println("5. Find items by name");
		System.out.println("6. Exit program");
	}

	/**
	 * Create Item (Point of Menu).
	 */
    public void createItem() {
        System.out.println("---------- Добавление новой заявки ---------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("---------- Новая заявка с id: " + item.getId() + " ---------");
    }

	/**
	 * Print All Items (Point of Menu).
	 */
	private void showAllItems() {
		System.out.println("---------- Добавление заявки: ---------");
		Item[] items = this.tracker.findAll();
		for (Item item : items) {
			item.print();
		}
	}

	/**
	 * Edit item by id (Point of Menu).
	 */
	private void editItem() {
		System.out.println("---------- Редактирование заявки ---------");
		String inputId = this.input.ask("Введите id заявки: ");
		Item oldItem = this.tracker.findById(inputId);
		if (oldItem == null) {
			System.out.println("Заявка с таким id не найдена");
			return;
		}
		String name = this.input.ask("Введите имя заявки: ");
		String desc = this.input.ask("Введите описание заявки: ");
		Item newItem = new Item(name, desc);
		this.tracker.replace(inputId, newItem);
	}

	/**
	 * Delete item by id (Point of Menu).
	 */
	private void deleteItem() {
		System.out.println("---------- Удаление заявки ---------");
		String inputId = this.input.ask("Введите id заявки: ");
		this.tracker.delete(inputId);
	}

	/**
	 * Find item by id (Point of Menu).
	 */
	private void findItemByID() {
		System.out.println("---------- Поиск заявки по id ---------");
		String inputId = this.input.ask("Введите id заявки: ");
		Item item = null;
		item = this.tracker.findById(inputId);
		if (item != null) {
			item.print();
		} else {
			System.out.println("Заявки с таким id не существует");
		}
	}

	/**
	 * Find item by id (Point of Menu).
	 */
	private void findItemByName() {
		System.out.println("---------- Поиск заявки по имени ---------");
		String inputName = this.input.ask("Введите имя заявки: ");
		Item[] items = null;
		items = this.tracker.findByName(inputName);
		if (items != null) {
			for (Item item : items) {
				item.print();
			}
		} else {
			System.out.println("Заявок с таким именем не существует");
		}
	}

    /**
     * Point ro start program.
     * @param args nothing
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

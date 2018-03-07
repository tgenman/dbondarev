package ru.job4j.tracker;

import ru.job4j.start.Input;

/**
 * @author tgenman
 * Created by tgenman on 3/4/18.
 */
public class MenuTracker {
	/** Realisation of input. */
	private Input input;

	/** Container to Items. */
	private Tracker tracker;

	/** Container to Actions. */
	private UserAction[] actions = new UserAction[7];

	/** Pointer to actions array.*/
	private int position = 0;

	/**
	 * Constructor.
	 * @param input instance of Input
	 * @param tracker instance of tracker
	 */
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/** Fill UserActions array. */
	public void fillActions() {
		this.actions[position++] = this.new AddItem(0, "Add new item");
		this.actions[position++] = new MenuTracker.ShowAllItems(1, "Show all items");
		this.actions[position++] = new EditItem(2, "Edit item");
		this.actions[position++] = this.new DeleteItem(3, "Delete item");
		this.actions[position++] = this.new FindItemById(4, "Find item by id");
		this.actions[position++] = this.new FindItemBYName(5, "Find items by name");
		this.actions[position++] = this.new Exit(6, "Exit program");
	}

	/**
	 * Select Action from UserActions array.
	 * @param key number of action
	 */
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}

	/** Show Menu. */
	public void showMenu() {
		System.out.println("Меню");
		for (UserAction action : this.actions) {
			System.out.println(action.info());
		}
	}

	/** Action 0: Add Item. */
	private class AddItem extends BaseAction {
		/**
		 * Constructor.
		 * @param key int
		 * @param name String
		 */
		AddItem(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("---------- Добавление новой заявки ---------");
			String name = input.ask("Введите имя заявки: ");
			String desc = input.ask("Введите описание заявки: ");
			Item item = new Item(name, desc);
			tracker.add(item);
			String.format("---------- Новая заявка с id: %s ---------", item.getId());
		}

		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Add new item");
		}
	}

	/** Action 1: Show All Items. */
	private static class ShowAllItems extends BaseAction {
		/**
		 * Constructor.
		 * @param key int
		 * @param name String
		 */
		ShowAllItems(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("---------- Показать все заявки: ---------");
			for (Item item : tracker.findAll()) {
				item.print();
			}
		}
	}

	/** Action 3: Delete Item. */
	private class DeleteItem extends BaseAction {
		/**
		 * Constructor.
		 * @param key int
		 * @param name String
		 */
		DeleteItem(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("---------- Удаление заявки ---------");
			String inputId = input.ask("Введите id заявки: ");
			tracker.delete(inputId);
		}
	}

	/** Action 4: Find Item By Id. */
	private class FindItemById extends BaseAction {
		/**
		 * Constructor.
		 * @param key int
		 * @param name String
		 */
		FindItemById(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("---------- Поиск заявки по id ---------");
			String inputId = input.ask("Введите id заявки: ");
			Item item = null;
			item = tracker.findById(inputId);
			if (item != null) {
				item.print();
			} else {
				System.out.println("Заявки с таким id не существует");
			}
		}
	}

	/** Action 5: Find Item By Name. */
	private class FindItemBYName extends BaseAction {
		/**
		 * Constructor.
		 * @param key int
		 * @param name String
		 */
		FindItemBYName(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("---------- Поиск заявки по имени ---------");
			String inputName = input.ask("Введите имя заявки: ");
			Item[] items = null;
			items = tracker.findByName(inputName);
			if (items != null) {
				for (Item item : items) {
					item.print();
				}
			} else {
				System.out.println("Заявок с таким именем не существует");
			}
		}
	}

	/** Action 6: Exit. */
	private class Exit extends BaseAction {
		/**
		 * Constructor.
		 * @param key int
		 * @param name String
		 */
		Exit(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) { }
	}
}

/** Action 2: Edit Item. */
class EditItem extends BaseAction {
	/**
	 * Constructor.
	 * @param key int
	 * @param name String
	 */
	EditItem(int key, String name) {
		super(key, name);
	}

	@Override
	public void execute(Input input, Tracker tracker) {
		System.out.println("---------- Редактирование заявки ---------");
		String inputId = input.ask("Введите id заявки: ");
		Item oldItem = tracker.findById(inputId);
		if (oldItem == null) {
			System.out.println("Заявка с таким id не найдена");
			return;
		}
		String name = input.ask("Введите имя заявки: ");
		String desc = input.ask("Введите описание заявки: ");
		Item newItem = new Item(name, desc);
		tracker.replace(inputId, newItem);
	}
}

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
		this.actions[0] = this.new AddItem();
		this.actions[1] = new MenuTracker.ShowAllItems();
		this.actions[2] = new EditItem();
		this.actions[3] = this.new DeleteItem();
		this.actions[4] = this.new FindItemById();
		this.actions[5] = this.new FindItemBYName();
		this.actions[6] = this.new Exit();
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
	private class AddItem implements UserAction {
		@Override
		public int key() {
			return 0;
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
	private static class ShowAllItems implements UserAction {
		@Override
		public int key() {
			return 1;
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("---------- Показать все заявки: ---------");
			for (Item item : tracker.findAll()) {
				item.print();
			}
		}

		@Override
		public String info() {
			return String.format("%s. %s", key(), "Show all items");
		}
	}

	/** Action 3: Delete Item. */
	private class DeleteItem implements UserAction {

		@Override
		public int key() {
			return 3;
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("---------- Удаление заявки ---------");
			String inputId = input.ask("Введите id заявки: ");
			tracker.delete(inputId);
		}

		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Delete item");
		}
	}

	/** Action 4: Find Item By Id. */
	private class FindItemById implements UserAction {

		@Override
		public int key() {
			return 4;
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

		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Find item by id");
		}
	}

	/** Action 5: Find Item By Name. */
	private class FindItemBYName implements UserAction {

		@Override
		public int key() {
			return 5;
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

		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Find items by name");
		}
	}

	/** Action 6: Exit. */
	private class Exit implements UserAction {
		@Override
		public int key() {
			return 6;
		}

		@Override
		public void execute(Input input, Tracker tracker) { }

		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Exit program");
		}
	}
}

/** Action 2: Edit Item. */
class EditItem implements UserAction {
	/**
	 * Number of point of menu.
	 * @return number of point of menu.
	 */
	@Override
	public int key() {
		return 2;
	}

	/**
	 * Execure Action.
	 * @param input instance of Input
	 * @param tracker instance of Tracker
	 */
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

	/**
	 * Print point of menu.
	 * @return action description
	 */
	@Override
	public String info() {
		return String.format("%s. %s", this.key(), "Edit item");
	}
}

package ru.job4j.generic;

/**
 * Created by tgenman on 4/12/18.
 * @param <T> T
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
	/** Container. */
	private SimpleArray<T> container = new SimpleArray<>();

	@Override
	public void add(T model) {
		container.add(model);
	}

	@Override
	public boolean replace(String id, T model) {
		for (T item : this.container) {
			if (item.getId().equals(id)) {
				this.container.set(container.getIndex(item), model);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		for (T item : this.container) {
			if (item.getId().equals(id)) {
				this.container.delete(container.getIndex(item));
				return true;
			}
		}
		return false;
	}

	@Override
	public T findById(String id) {
		for (T item : this.container) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
}

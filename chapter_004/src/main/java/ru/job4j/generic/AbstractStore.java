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
		boolean result = false;
		for (T item : this.container) {
			if (item.getId().equals(id)) {
				this.container.set(container.getIndex(item), model);
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean delete(String id) {
		boolean result = false;
		for (T item : this.container) {
			if (item.getId().equals(id)) {
				this.container.delete(container.getIndex(item));
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public T findById(String id) {
		T result = null;
		for (T item : this.container) {
			if (item.getId().equals(id)) {
				result = item;
			}
		}
		return result;
	}
}

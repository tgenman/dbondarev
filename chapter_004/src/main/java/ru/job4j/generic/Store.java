package ru.job4j.generic;


/**
 * Created by tgenman on 4/12/18.
 * @param <T> T
 */
public interface Store<T extends Base> {
	/**
	 * Add.
	 * @param model T
	 */
	void add(T model);

	/**
	 * Replace.
	 * @param id String
	 * @param model model
	 * @return boolean
	 */
	boolean replace(String id, T model);

	/**
	 * Delete.
	 * @param id String
	 * @return boolean
	 */
	boolean delete(String id);

	/**
	 * Find By Id.
	 * @param id String
	 * @return T
	 */
	T findById(String id);
}

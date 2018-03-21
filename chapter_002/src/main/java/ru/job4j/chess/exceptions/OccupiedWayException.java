package ru.job4j.chess.exceptions;

/**
 * Created by tgenman on 3/9/18.
 */
public class OccupiedWayException extends RuntimeException {
	/**
	 * Constructor.
	 * @param msg messenge for User.
	 */
	public OccupiedWayException(String msg) {
		super(msg);
	}
}

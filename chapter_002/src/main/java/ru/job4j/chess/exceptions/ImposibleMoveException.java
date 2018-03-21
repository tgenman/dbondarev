package ru.job4j.chess.exceptions;

/**
 * Created by tgenman on 3/9/18.
 */
public class ImposibleMoveException extends RuntimeException {
	/**
	 * Constructor.
	 * @param msg messenge for User.
	 */
	public ImposibleMoveException(String msg) {
		super(msg);
	}
}

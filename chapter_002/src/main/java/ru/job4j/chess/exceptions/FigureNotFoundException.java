package ru.job4j.chess.exceptions;

/**
 *
 *
 * Created by tgenman on 3/9/18.
 */
public class FigureNotFoundException extends RuntimeException {
	/**
	 * Constructor.
	 * @param msg messenge for User.
	 */
	public FigureNotFoundException(String msg) {
		super(msg);
	}
}

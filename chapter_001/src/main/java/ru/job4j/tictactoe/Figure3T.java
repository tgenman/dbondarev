package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Figure.
 */
public class Figure3T extends Rectangle {
	/** Has it X.*/
	private boolean markX = false;

	/** Has it O. */
	private boolean markO = false;

	/**
	 * Constructor.
	 */
	public Figure3T() {
		this(false);
	}

	/**
	 * Constructor.
	 * @param markX boolean
	 */
	public Figure3T(boolean markX) {
		this.markX = markX;
		this.markO = !markX;
	}

	/**
	 * Take X.
	 * @param markX boolean
	 */
	public void take(boolean markX) {
		this.markX = markX;
		this.markO = !markX;
	}

	/**
	 * Getter X.
	 * @return boolean
	 */
	public boolean hasMarkX() {
		return this.markX;
	}

	/**
	 * Getter O.
	 * @return boolean
	 */
	public boolean hasMarkO() {
		return this.markO;
	}
}

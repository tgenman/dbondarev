package ru.job4j.chess;

/**
 * Created by tgenman on 3/9/18.
 */
public class Cell {
	/** Coordinate X. */
	private int x;

	/** Coordinate Y. */
	private int y;

	/**
	 * Constructor.
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter X.
	 * @return int X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter Y.
	 * @return int Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Print Cell.
	 */
	public void print() {
		System.out.println("X = " + this.x + "; Y = " + this.y);
	}
}

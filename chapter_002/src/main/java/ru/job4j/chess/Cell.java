package ru.job4j.chess;

/**
 * Created by tgenman on 3/9/18.
 */
public class Cell {
	private int x;
	private int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void print() {
		System.out.println("X = " + this.x + "; Y = " + this.y);
	}
}

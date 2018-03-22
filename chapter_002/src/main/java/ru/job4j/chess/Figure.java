package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * Created by tgenman on 3/7/18.
 */
public abstract class Figure {
	/** Coordinates of Figure. */
	private final Cell position;

	/** Flag of Figure is knight or not. */
	private final boolean isItKnight = false;

	/**
	 * Constructor.
	 * @param position Cell
	 */
	Figure(Cell position) {
		this.position = position;
	}

	/**
	 * Prove Figure ability to move new destination.
	 * If can then return Cell[], else throw ImpossibleMoveException
	 * @param source current Cell
	 * @param dest destination Cell
	 * @return Cell[]
	 * @throws ImposibleMoveException Exception
	 */
	abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

	/**
	 * .
	 * @param dest Cell to new position of Figure
	 * @return new instance of Figure
	 */
	abstract Figure copy(Cell dest);

	/**
	 * Chech Cell to having Figure.
	 * @param cell Cell
	 * @return boolean answer
	 */
	boolean checkCellHasFigure(Cell cell) {
		boolean result = false;
		if ((this.position.getX() == cell.getX())
				&& (this.position.getY() == cell.getY())
				) {
			result = true;
		}
		return result;
	}

	/**
	 * Getter to isItKnight.
	 * @return boolean
	 */
	public boolean isItKnight() {
		return this.isItKnight;
	}
}

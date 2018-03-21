package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * Created by tgenman on 3/7/18.
 */
public abstract class Figure {
	final Cell position;
	final boolean isItKnight = false;

	Figure(Cell position) {
		this.position = position;
	}

	/**
	 * Prove Figure ability to move new destination.
	 * If can then return Cell[], else throw ImpossibleMoveException
	 * @param source current Cell
	 * @param dest destination Cell
	 * @return
	 */
	abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

	/**
	 * .
	 * @param dest Cell to new position of Figure
	 * @return new instance of Figure
	 */
	abstract Figure copy(Cell dest);

	boolean checkCellHasFigure(Cell cell) {
		boolean result = false;
		if ((this.position.getX() == cell.getX()) &&
				(this.position.getY() == cell.getY())
				) {
			result = true;
		}
		return result;
	}


}

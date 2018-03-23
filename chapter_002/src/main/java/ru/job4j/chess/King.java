package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * Created by tgenman on 3/23/18.
 */
public class King extends Figure {
	/**
	 * Constructor.
	 * @param position Cell
	 */
	public King(Cell position) {
		super(position);
	}

	@Override
	Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
		this.checkRouteToAccepteble(source, dest);
		return this.generateRouteCells(source, dest);
	}

	@Override
	Figure copy(Cell dest) {
		return new King(dest);
	}

	/**
	 * Check Route.
	 * @param source Cell of start
	 * @param dest Cell of finish
	 * @throws ImposibleMoveException if route is not acceptable.
	 */
	private void checkRouteToAccepteble(Cell source, Cell dest) throws ImposibleMoveException {
		int x1 = source.getX();
		int y1 = source.getY();
		int x2 = dest.getX();
		int y2 = dest.getY();
		int deltaX = Math.abs(x2 - x1);
		int deltaY = Math.abs(y2 - y1);
		if (deltaX <= 1 && deltaY <= 1) {
			return;
		} else {
			throw new ImposibleMoveException("Фигура не может ходить так");
		}
	}

	/**
	 * Generate array of route's Cells.
	 * @param source Cell of start
	 * @param dest Cell of finish
	 * @return array of route's Cells
	 */
	private Cell[] generateRouteCells(Cell source, Cell dest) {
		Cell[] result = new Cell[2];
		result[0] = source;
		result[1] = dest;
		return result;
	}
}

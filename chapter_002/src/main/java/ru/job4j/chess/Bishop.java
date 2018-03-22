package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * Created by tgenman on 3/9/18.
 */
public class Bishop extends Figure {
	/**
	 * Constructor.
	 * @param position Cell of Bishop.
	 */
	Bishop(Cell position) {
		super(position);
	}

	@Override
	Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
		this.checkRouteToAccepteble(source, dest);
		return this.generateRouteCells(source, dest);
	}

	@Override
	Figure copy(Cell dest) {
		return new Bishop(dest);
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
		if (deltaX != deltaY) {
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
		int x1 = source.getX();
		int y1 = source.getY();
		int x2 = dest.getX();
		int y2 = dest.getY();
		int delta = x2 - x1;
		int deltaABC = Math.abs(delta);
		int coefX = (x2 - x1) / deltaABC;
		int coefY = (y2 - y1) / deltaABC;
		Cell[] result = new Cell[deltaABC + 1];
		result[0] = source;
		result[deltaABC] = dest;
		for (int index = 1; index < deltaABC; index++) {
			result[index] = new Cell(x1 + coefX * index, y1 + coefY * index);
		}
		return result;
	}
}

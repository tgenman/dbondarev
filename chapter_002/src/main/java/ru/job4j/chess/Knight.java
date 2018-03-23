package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * Created by tgenman on 3/23/18.
 */
public class Knight extends Figure {
	/** It is Knight.
	 * For jumping route.
	 */
	private final boolean isItKnight = true;

	/**
	 * Constructor.
	 * @param position Cell
	 */
	public Knight(Cell position) {
		super(position);
	}

	@Override
	Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
		this.checkRouteToAccepteble(source, dest);
		return this.generateRouteCells(source, dest);
	}

	@Override
	Figure copy(Cell dest) {
		return new Knight(dest);
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
		if (y2 == (y1 - 1) && (x2 == (x1 + 2) || x2 == (x1 - 2))) {
			return;
		}
		if (y2 == (y1 + 1) && (x2 == (x1 + 2) || x2 == (x1 - 2))) {
			return;
		}
		if (y2 == (y1 - 2) && (x2 == (x1 + 1) || x2 == (x1 - 1))) {
			return;
		}
		if (y2 == (y1 + 2) && (x2 == (x1 + 1) || x2 == (x1 - 1))) {
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

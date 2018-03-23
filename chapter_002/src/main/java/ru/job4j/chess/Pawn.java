package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * Created by tgenman on 3/23/18.
 */
public class Pawn extends Figure {
	/**
	 * Constructor.
	 * @param position Cell
	 */
	public Pawn(Cell position) {
		super(position);
	}

	@Override
	Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
		this.checkRouteToAccepteble(source, dest);
		return this.generateRouteCells(source, dest);
	}

	@Override
	Figure copy(Cell dest) {
		return new Pawn(dest);
	}

	/**
	 * Check Route.
	 * @param source Cell of start
	 * @param dest Cell of finish
	 * @throws ImposibleMoveException if route is not acceptable.
	 */
	private void checkRouteToAccepteble(Cell source, Cell dest) throws ImposibleMoveException {
		int y1 = source.getY();
		int y2 = dest.getY();
		if (y1 == 1 && (y2 == 2 || y2 == 3)) {
			return;
		} else if (y2 == (y1 + 1)) {
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
		int x1 = source.getX();
		int y1 = source.getY();
		int y2 = dest.getY();
		Cell[] result = new Cell[1];
		if (y1 == 1 && y2 == 3) {
			result = new Cell[3];
			result[0] = source;
			result[1] = new Cell(x1, y1 + 1);
			result[2] = dest;
		} else if (y2 == (y1 + 1)) {
			result = new Cell[2];
			result[0] = source;
			result[1] = dest;
		}
		return result;
	}
}

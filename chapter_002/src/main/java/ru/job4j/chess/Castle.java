package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * Created by tgenman on 3/23/18.
 */
public class Castle extends Figure {
	/**
	 * Constructor.
	 * @param position Cell
	 */
	public Castle(Cell position) {
		super(position);
	}

	@Override
	Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
		this.checkRouteToAccepteble(source, dest);
		return this.generateRouteCells(source, dest);
	}

	@Override
	Figure copy(Cell dest) {
		return new Castle(dest);
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
		if (x1 != x2
				&& y1 != y2) {
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
		Cell[] result = new Cell[1];
		if (x1 == x2) {
			int delta = y2 - y1;
			int deltaABC = Math.abs(delta);
			int coefY = (y2 - y1) / deltaABC;
			result = new Cell[deltaABC + 1];
			result[0] = source;
			result[deltaABC] = dest;
			for (int index = 1; index < deltaABC; index++) {
				result[index] = new Cell(x1, y1 + coefY * index);
			}
		}
		if (y1 == y2) {
			int delta = x2 - x1;
			int deltaABC = Math.abs(delta);
			int coefX = (x2 - x1) / deltaABC;
			result = new Cell[deltaABC + 1];
			result[0] = source;
			result[deltaABC] = dest;
			for (int index = 1; index < deltaABC; index++) {
				result[index] = new Cell(x1 + coefX * index, y1);
			}
		}
		return result;
	}
}

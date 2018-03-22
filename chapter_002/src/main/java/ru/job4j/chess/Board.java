package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImposibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

/**
 * Created by tgenman on 3/7/18.
 */
public class Board {
	/** Array to figures. */
	private Figure[] figures = new Figure[32];

	/** Pointer to Array. */
	private int position = 0;

	/**
	 * Add Figure to board.
	 * @param figure Figure
	 */
	void add(Figure figure) {
		figures[position++] = figure;
	}

	/**
	 * Move Figure by Board.
	 * @param source Cell
	 * @param dest Cell
	 * @return boolean of result
	 * @throws ImposibleMoveException Exception
	 * @throws OccupiedWayException Exception
	 * @throws FigureNotFoundException Exception
	 */
	boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
		int indexFigure;
		if (this.checkCellHasOneOfFigures(source)) {
			indexFigure = this.returnIndexOfFigure(source);
		} else {
			throw new FigureNotFoundException("В этой ячейке нет фигуры");
		}
		Cell[] route = figures[indexFigure].way(source, dest);
		this.checkRoute(route, indexFigure);
		figures[indexFigure] = figures[indexFigure].copy(dest);
		return true;
	}

	/**
	 * Return Index Of Figure.
	 * @param cell Cell
	 * @return Index Figure in array of figures
	 */
	private int returnIndexOfFigure(Cell cell) {
		for (int index = 0; index < figures.length; index++) {
			if (figures[index] != null) {
				if (figures[index].checkCellHasFigure(cell)) {
					return index;
				}
			}
		}
		return -1;
	}

	/**
	 * Check Cell to free.
	 * @param cell Cell
	 * @return boolean answer
	 */
	private boolean checkCellHasOneOfFigures(Cell cell) {
		boolean result = false;
		for (int index = 0; index < figures.length; index++) {
			if (figures[index] != null) {
				if (figures[index].checkCellHasFigure(cell)) {
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * Check Route.
	 * @param route Cell[]
	 * @param indexFigure index of Figure to array of figures
	 */
	private void checkRoute(Cell[] route, int indexFigure) {
		if (figures[indexFigure].isItKnight()) {
			return;
		}
 		for (int index = 1; index < route.length; index++) {
			if (this.checkCellHasOneOfFigures(route[index])) {
				throw new OccupiedWayException("Путь фигуры занят");
			}
		}
	}

	/**
	 * Getter to figures to test.
	 * @param index of array
	 * @return Figure witn this index
	 */
	public Figure getFigure(int index) {
		return this.figures[index];
	}
}

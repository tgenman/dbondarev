package ru.job4j.chess;


import org.junit.Test;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.OccupiedWayException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by tgenman on 3/9/18.
*/
public class BoardTest {
	/**
	 * Test whenAddNewFigureThenBoardHasSameItem.
	 */
	@Test
	public void whenAddNewFigureThenBoardHasSameItem() {
		Board board = new Board();
		Figure one = new Bishop(new Cell(1, 1));
		board.add(one);
		assertThat(board.getFigure(0), is(one));
	}

	/**
	 * Test whenMoveFigureThenFigureMove.
	 */
	@Test
	public void whenMoveFigureThenFigureMove() {
		Board board = new Board();
		Figure one = new Bishop(new Cell(2, 2));
		board.add(one);
		Cell src = new Cell(2, 2);
		Cell dest = new Cell(4, 4);
		assertThat(board.move(src, dest), is(true));
	}

	/**
	 * Test whenFigureIsNotThenGenerateFigureNotFoundException.
	 */
	@Test
	public void whenFigureIsNotThenGenerateFigureNotFoundException() {
		Board board = new Board();
		Figure one = new Bishop(new Cell(3, 3));
		board.add(one);
		Cell src = new Cell(2, 2);
		Cell dest = new Cell(4, 4);
		String result = "В этой ячейке нет фигуры";
		String answer = "";
		try {
			board.move(src, dest);
		} catch (FigureNotFoundException fnfe) {
			answer = fnfe.getMessage();
		}
		assertThat(answer, is(result));
	}

	/**
	 * Test whenRouteIsOccupiedThenGenerateOccupiedWayException.
	 */
	@Test
	public void whenRouteIsOccupiedThenGenerateOccupiedWayException() {
		Board board = new Board();
		Figure one = new Bishop(new Cell(2, 2));
		Figure two = new Bishop(new Cell(3, 3));
		board.add(one);
		board.add(two);
		Cell src = new Cell(2, 2);
		Cell dest = new Cell(4, 4);
		String result = "Путь фигуры занят";
		String answer = "";
		try {
			board.move(src, dest);
		} catch (OccupiedWayException owe) {
			answer = owe.getMessage();
		}
		assertThat(answer, is(result));
	}
}

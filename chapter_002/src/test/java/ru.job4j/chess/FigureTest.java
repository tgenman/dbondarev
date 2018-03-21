package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tgenman on 3/21/18.
 */
public class FigureTest {

	@Test
	public void whenCheckCellHasFigureThenCellHas() {
		Board board = new Board();
		Figure one = new Bishop(new Cell(1, 1));
		board.add(one);
		assertThat(board.figures[0].checkCellHasFigure(new Cell(1, 1)), is(true));
	}

	@Test
	public void whenCheckCellHasFigureThenCellHasNot1() {
		Board board = new Board();
		Figure one = new Bishop(new Cell(1, 1));
		board.add(one);
		assertThat(board.figures[0].checkCellHasFigure(new Cell(1, 5)), is(false));
	}

	@Test
	public void whenCheckCellHasFigureThenCellHasNot2() {
		Board board = new Board();
		Figure one = new Bishop(new Cell(1, 1));
		board.add(one);
		assertThat(board.figures[0].checkCellHasFigure(new Cell(6, 1)), is(false));
	}
}
package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exceptions.ImposibleMoveException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tgenman on 3/23/18.
 */
public class PawnTest {

	/**
	 * Test when route is right 1 to start position.
	 */
	@Test
	public void whenWayRightToStartPositionThenReturnRoute() {
		Cell source = new Cell(2, 1);
		Cell point1 = new Cell(2, 2);
		Cell dest = new Cell(2, 3);
		Figure one = new Pawn(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(3));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(point1.getX()));
		assertThat(route[1].getY(), is(point1.getY()));
		assertThat(route[2].getX(), is(dest.getX()));
		assertThat(route[2].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 2 to another position.
	 */
	@Test
	public void whenWayRightToAnotherPositionThenReturnRoute() {
		Cell source = new Cell(2, 3);
		Cell dest = new Cell(2, 4);
		Figure one = new Pawn(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is wrong.
	 */
	@Test
	public void whenWayWrongThenGenerateException() {
		Cell source = new Cell(2, 2);
		Cell dest = new Cell(4, 1);
		Figure one = new Pawn(source);
		String result = "Фигура не может ходить так";
		String answer = "";
		try {
			Cell[] route = one.way(source, dest);
		} catch (ImposibleMoveException ime) {
			answer = ime.getMessage();
		}
		assertThat(answer, is(result));
	}
}

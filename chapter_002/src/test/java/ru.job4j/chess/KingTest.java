package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exceptions.ImposibleMoveException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tgenman on 3/23/18.
 */
public class KingTest {

	/**
	 * Test when route is right.
	 */
	@Test
	public void whenWayRightThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(3, 2);
		Figure one = new King(source);
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
		Cell dest = new Cell(4, 2);
		Figure one = new King(source);
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

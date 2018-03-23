package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exceptions.ImposibleMoveException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tgenman on 3/23/18.
 */
public class KnightTest {
	/**
	 * Test when route is right 1.
	 */
	@Test
	public void whenWayRightOneThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(2, 5);
		Figure one = new Knight(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 2.
	 */
	@Test
	public void whenWayRightTwoThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(4, 5);
		Figure one = new Knight(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 3.
	 */
	@Test
	public void whenWayRightThreeThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(2, 1);
		Figure one = new Knight(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 4.
	 */
	@Test
	public void whenWayRightFourThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(4, 1);
		Figure one = new Knight(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 5.
	 */
	@Test
	public void whenWayRightFiveThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(1, 4);
		Figure one = new Knight(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 6.
	 */
	@Test
	public void whenWayRightSixThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(5, 4);
		Figure one = new Knight(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 7.
	 */
	@Test
	public void whenWayRightSevenThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(1, 2);
		Figure one = new Knight(source);
		Cell[] route = one.way(source, dest);
		assertThat(route.length, is(2));
		assertThat(route[0].getX(), is(source.getX()));
		assertThat(route[0].getY(), is(source.getY()));
		assertThat(route[1].getX(), is(dest.getX()));
		assertThat(route[1].getY(), is(dest.getY()));
	}

	/**
	 * Test when route is right 8.
	 */
	@Test
	public void whenWayRightEightThenReturnRoute() {
		Cell source = new Cell(3, 3);
		Cell dest = new Cell(5, 2);
		Figure one = new Knight(source);
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
		Figure one = new Knight(source);
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

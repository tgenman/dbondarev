package ru.job4j.pseudo;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author tgenman.
 * Created by tgenman on 3/1/18.
 */
public class SquareTest {
	/**
	 * Test to drawing square.
	 */
	@Test
	public void whenDrawSquare() {
		final String line = System.getProperty("line.separator");
		Square square = new Square();
		assertThat(
				square.draw(),
				is(
						new StringBuilder()
								.append("++++").append(line)
								.append("+  +").append(line)
								.append("+  +").append(line)
								.append("++++").append(line)
								.toString()
				)
		);
	}
}


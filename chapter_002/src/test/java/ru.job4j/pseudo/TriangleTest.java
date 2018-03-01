package ru.job4j.pseudo;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author tgenman.
 * Created by tgenman on 3/1/18.
 */
public class TriangleTest {
	/**
	 * Test to draw triangle.
	 */
	@Test
	public void whenDrawTriangle() {
		final String line = System.getProperty("line.separator");
		Triangle triangle = new Triangle();
		assertThat(
				triangle.draw(),
				is(
						new StringBuilder()
								.append("+   ").append(line)
								.append("++  ").append(line)
								.append("+ + ").append(line)
								.append("++++").append(line)
								.toString()
				)
		);
	}
}

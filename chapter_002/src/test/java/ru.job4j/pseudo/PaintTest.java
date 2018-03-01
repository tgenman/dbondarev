package ru.job4j.pseudo;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author tgenman.
 * Created by tgenman on 3/1/18.
 */
public class PaintTest {
	/**
	 * Test to paint.
	 */
	@Test
	public void whenDrawSquare() {
		final String line = System.getProperty("line.separator");
		PrintStream stdout = System.out;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		new Paint().draw(new Square());
		assertThat(
				new String(out.toByteArray()),
				is(
						new StringBuilder()
								.append("++++").append(line)
								.append("+  +").append(line)
								.append("+  +").append(line)
								.append("++++").append(line).append(line)
								.toString()
				)
		);
		System.setOut(stdout);
	}
}

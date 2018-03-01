package ru.job4j.pseudo;


import org.junit.After;
import org.junit.Before;
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
	/** Default stdout */
	private final PrintStream stdout = System.out;
	/** Test stdout */
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	/** Choose line separator */
	final String line = System.getProperty("line.separator");

	@Before
	public void loadOutput() {
		System.setOut(new PrintStream(this.out));
	}

	@After
	public void backOutput() {
		System.setOut(this.stdout);
	}
	/**
	 * Test to paint square.
	 */
	@Test
	public void whenDrawSquare() {
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
	}

	/**
	 * Test to paint triangle.
	 */
	@Test
	public void whenDrawTriangle() {
		new Paint().draw(new Triangle());
		assertThat(
				new String(out.toByteArray()),
				is(
						new StringBuilder()
								.append("+   ").append(line)
								.append("++  ").append(line)
								.append("+ + ").append(line)
								.append("++++").append(line).append(line)
								.toString()
				)
		);
	}
}

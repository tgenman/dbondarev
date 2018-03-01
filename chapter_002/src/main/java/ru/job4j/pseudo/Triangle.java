package ru.job4j.pseudo;

/**
 * Created by tgenman on 3/1/18.
 */
public class Triangle implements Shape {
	/**
	 * Drawing Triangle.
	 * @return String of triangle.
	 */
	@Override
	public String draw() {
		final String line = System.getProperty("line.separator");
		StringBuilder pic = new StringBuilder();
		pic.append("+   ");
		pic.append(line);
		pic.append("++  ");
		pic.append(line);
		pic.append("+ + ");
		pic.append(line);
		pic.append("++++");
		pic.append(line);
		return pic.toString();
	}
}

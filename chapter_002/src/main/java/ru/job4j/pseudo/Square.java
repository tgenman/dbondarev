package ru.job4j.pseudo;

/**
 * @author tgenman
 * Created by tgenman on 3/1/18.
 */
public class Square implements Shape {
	/**
	 * Drawing Square.
	 * @return String of Square.
	 */
	@Override
	public String draw() {
		final String line = System.getProperty("line.separator");
		StringBuilder pic = new StringBuilder();
		pic.append("++++");
		pic.append(line);
		pic.append("+  +");
		pic.append(line);
		pic.append("+  +");
		pic.append(line);
		pic.append("++++");
		pic.append(line);
		return pic.toString();
	}

}

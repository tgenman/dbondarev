package ru.job4j.loop;
/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        final String line = System.getProperty("line.separator");
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i % 2) == 0  &&  (j % 2) == 0) {
                    builder.append("x");
                }
                if ((i % 2) != 0  &&  (j % 2) != 0) {
                    builder.append("x");
                }
                if ((i % 2) == 0  &&  (j % 2) != 0) {
                    builder.append(" ");
                }
                if ((i % 2) != 0  &&  (j % 2) == 0) {
                    builder.append(" ");
                }
            }
            builder.append(line);
        }
        return builder.toString();
    }
}

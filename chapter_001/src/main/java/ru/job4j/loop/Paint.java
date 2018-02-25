package ru.job4j.loop;
/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Paint piramid height of n.
     * @param h int
     * @return String
     */
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        final String line = System.getProperty("line.separator");
        int width = 2 * h - 1;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= width; j++) {
                if (j > (h - i)  &&  j < (h + i)) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }
            }
            builder.append(line);
        }

        return builder.toString();
    }
}

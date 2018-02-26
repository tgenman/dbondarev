package ru.job4j.professions;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Profession {
    /** Name. */
    private String name;
    /** Age. */
    private int age;
    /** Diploma. */
    private Diploma diploma;
    /** Salary. */
    private int salary;

    /**
     * Getter to name.
     * @return String
     */
    public String getName() {
        return name;
    }
}

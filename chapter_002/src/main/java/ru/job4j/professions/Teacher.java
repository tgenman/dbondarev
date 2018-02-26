package ru.job4j.professions;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    /**
     * Teaching of student.
     * @param student Student to teaching.
     */
    public void teach(Student student) {
        System.out.println("Учитель " + this.getName() + " учит " + student.getName());
    }

    /**
     * Examing of student.
     * @param student Student to examing.
     * @return Diploma.
     */
    public Diploma exam(Student student) {
        System.out.println("Учитель " + this.getName() + " учит " + student.getName());
        return new Diploma();
    }
}

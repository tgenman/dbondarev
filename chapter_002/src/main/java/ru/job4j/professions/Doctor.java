package ru.job4j.professions;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
    /**
     * Heal of Patient.
     * @param patient Patient
     * @return Diagnose
     */
    public Diagnose heal(Patient patient) {
        System.out.println("Доктор " + this.getName() + " лечит " + patient.getName());
        return new Diagnose();
    }

    /**
     * Euthanasia of Patient.
     * @param patient Patient
     */
    public void euthanasia(Patient patient) {
        System.out.println("Доктор " + this.getName() + " применил эвтаназию к " + patient.getName());
    }


}

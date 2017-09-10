package ru.job4j.professions;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {

    public Diagnose heal(Pacient pacient) {
        System.out.println("Доктор " + this.getName() + " лечит " + pacient.getName());
        return new Diagnose();
    }

    public void euthanasia(Pacient pacient) {
        System.out.println("Доктор " + this.getName() + " применил эвтаназию к " + pacient.getName());
    }


}

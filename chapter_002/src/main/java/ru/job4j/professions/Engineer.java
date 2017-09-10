package ru.job4j.professions;

/**
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {

    public Building constract(Blueprint blueprint) {
        System.out.println("Инженер " + this.getName() + " строит " + blueprint.getName());
        return new Building();
    }

    public void demantle(Building building) {
        System.out.println("Инженер " + this.getName() + " строит " + building.getName());
    }
}

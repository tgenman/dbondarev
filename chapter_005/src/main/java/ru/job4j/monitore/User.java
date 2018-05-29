package ru.job4j.monitore;

import java.util.Objects;

/**
 * User class.
 */
public class User {

    private int id;

    private int amount;

    /**
     * Constructor.
     * @param id int
     * @param amount int
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Getter Id.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Getter Amount.
     * @return int
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter Amount.
     * @param amount int
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

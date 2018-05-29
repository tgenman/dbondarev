package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * User Storage.
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Map<Integer, User> container = new HashMap<>();

    /**
     * Add.
     * @param user User
     * @return boolean
     */
    synchronized boolean add(User user) {
        boolean result = false;
        if (!this.container.containsKey(user.getId())) {
            this.container.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    /**
     * Update.
     * @param user User
     * @return boolean
     */
    synchronized boolean update(User user) {
        boolean result = false;
        if (this.container.containsKey(user.getId())) {
            this.container.replace(user.getId(), user);
            result = true;
        }
        return result;

    }

    /**
     * Delete.
     * @param user User
     * @return boolean
     */
    synchronized boolean delete(User user) {
        return this.container.remove(user.getId(), user);
    }

    /**
     * Transfer.
     * @param fromId int
     * @param toId int
     * @param amount int
     * @return boolean
     */
    synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (this.container.containsKey(fromId)
                && this.container.containsKey(toId)
                && this.container.get(fromId).getAmount() >= amount) {
            this.container.get(fromId).setAmount(
                    this.container.get(fromId).getAmount() - amount);
            this.container.get(toId).setAmount(
                    this.container.get(toId).getAmount() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Getter Amount by Id.
     * @param id int
     * @return int
     */
    synchronized int getAmountById(int id) {
        int result = -1;
        if (containsId(id)) {
            result = this.container.get(id).getAmount();
        }
        return result;
    }

    /**
     * Contains Id.
     * @param id int
     * @return boolean
     */
    synchronized boolean containsId(int id) {
        return this.container.containsKey(id);
    }
}

package ru.job4j.tree;

import java.util.Optional;

/**
 * Interface for Tree.
 * @param <E> type for tree value
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add Child in Parent.
     * @param parent parent.
     * @param child child.
     * @return boolean result of adding
     */
    boolean add(E parent, E child);

    /**
     * Find Node by value of Node.
     * @param value for search
     * @return Node or null. Cover in Optional.
     */
    Optional<Node<E>> findBy(E value);
}

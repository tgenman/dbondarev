package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node for construction of graph.
 * @param <E> type of value
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    /**
     * Constructor with value.
     * @param value value.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Add Child Node to Node.
     * @param child Node for adding
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Give all children of Node.
     * @return list of children
     */
    List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Comparator for Nodes.
     * @param that value for compare.
     * @return result of compare
     */
    boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    /**
     * Getter for Value.
     * @return value
     */
    E getValue() {
        return this.value;
    }
}


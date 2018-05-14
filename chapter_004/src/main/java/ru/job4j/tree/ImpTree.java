package ru.job4j.tree;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;

/**
 * Implementation of SimpleTree.
 * @param <E> type of values
 */
public class ImpTree<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> root;
    private static final Logger log = Logger.getLogger(ImpTree.class.getName());

    /**
     * Constructor with root value.
     * @param root root value
     */
    public ImpTree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> resultOfSearch = this.findBy(parent);
        if (resultOfSearch.isPresent()) {
            resultOfSearch.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /**
     * Implementation of iterator for ImpTree.
     * @param <E> type of value
     */
    private class TreeIterator<E extends Comparable<E>> implements Iterator<E> {

        private Queue<Node<E>> data = new LinkedList<>();

        TreeIterator() {
            Queue<Node<E>> buffer = new LinkedList<>();
            buffer.offer((Node<E>) root);
            while (!buffer.isEmpty()) {
                Node<E> elem = buffer.poll();
                this.data.add(elem);
                for (Node<E> child : elem.leaves()) {
                    buffer.add(child);
                }
            }

        }

        @Override
        public boolean hasNext() {
            return !this.data.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return this.data.poll().getValue();
        }
    }
}

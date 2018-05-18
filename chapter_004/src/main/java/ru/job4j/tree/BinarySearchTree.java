package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Binary Search Tree (BST).
 */
public class BinarySearchTree implements Iterable {

    private INode root;

    private int size;

    /**
     * Constructor with initial element.
     * @param value Integer.
     */
    public BinarySearchTree(Integer value) {
        this.root = new BinaryNode(value, null, null);
        this.size = 1;
    }

    /**
     * Add element to BST.
     * @param e Integer
     */
    public void add(Integer e) {
        this.root = root.add(e);
        size++;
    }

    /**
     * Get size of BST.
     * @return ins size
     */
    public int size() {
        return this.size;
    }

    /**
     * Return list of elements.
     * @return list of elements
     */
    public List<Integer> toList() {
        final TreeToList treeToList = new TreeToList();
        this.root.forEach(treeToList);
        return treeToList.getList();
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator();
    }

    /**
     * Iterator implementstion.
     */
    private class TreeIterator implements Iterator {

        private final List<Integer> buffer;

        private int positionNextElement;

        private TreeIterator() {
            this.buffer = BinarySearchTree.this.toList();
            this.positionNextElement = 0;
        }

        @Override
        public boolean hasNext() {
            return positionNextElement < BinarySearchTree.this.size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return this.buffer.get(positionNextElement++);
        }
    }

    /**
     * Consumer to create lis of elements.
     */
    private class TreeToList implements INode.IConsumer<Integer> {

        private final List<Integer> storage = new ArrayList<>();

        @Override
        public void consume(Integer value) {
            this.storage.add(value);
        }

        public List<Integer> getList() {
            return this.storage;
        }
    }

}

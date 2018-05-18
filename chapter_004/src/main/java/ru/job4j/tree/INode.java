package ru.job4j.tree;

/**
 * INode.
 * @param <T> T
 */
public interface INode<T> {

    /**
     * Return new INode with added element.
     * @param value elements for add.
     * @return new INode
     */
    INode add(final T value);

    /**
     * To use consumer logic to all elements.
     * @param consumer interface
     */
    void forEach(final IConsumer<T> consumer);

    /**
     * Count all elements of Tree.
     * @return number of elements.
     */
    int count();

    /**
     * Consumer.
     * @param <R> R
     */
    interface IConsumer<R> {

        /**
         * Logic out of class.
         * @param value R
         */
        void consume(final R value);
    }
}

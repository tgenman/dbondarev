package ru.job4j.tree;

/**
 * Node for binary sorted tree.
 */
public class BinaryNode implements INode<Integer> {

    private final int value;

    private final INode left;

    private final INode right;

    /**
     * Constructor.
     * @param value int
     * @param left link to left node
     * @param right link to right node
     */
    public BinaryNode(final int value, final INode left, final INode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public INode add(final Integer value) {
        if (value == this.value) return this;
        if (value < this.value) {
            if (left == null) {
                return new BinaryNode(this.value, new BinaryNode(value, null, null), right);
            }
            return new BinaryNode(this.value, left.add(value), right);
        }
        if (right == null) {
            return new BinaryNode(this.value, left, new BinaryNode(value, null, null));
        }
        return new BinaryNode(this.value, left, right.add(value));
    }

    @Override
    public void forEach(final IConsumer<Integer> consumer) {
        if (left != null) left.forEach(consumer);
        consumer.consume(value);
        if (right != null) right.forEach(consumer);
    }

    @Override
    public int count() {
        int leftCount = left != null ? left.count() : 0;
        int rightCount = right != null ? left.count() : 0;
        return leftCount + 1 + rightCount;
    }
}

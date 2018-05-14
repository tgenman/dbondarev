package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Tests.
 */
public class ImpTreeTest {
    /**
     * Test 1.
     */
    @Test
    public void when6ElFindLastThen6() {
        ImpTree<Integer> tree = new ImpTree<>(1);

        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Test 2.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        ImpTree<Integer> tree = new ImpTree<>(1);

        tree.add(1, 2);

        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Test 3.
     */
    @Test
    public void testIterator() {
        ImpTree<Integer> tree = new ImpTree<>(1);

        tree.add(1, 2);
        tree.add(1, 3);

        Iterator itr = tree.iterator();

        assertTrue(itr.hasNext());
        assertEquals(itr.next(), 1);
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), 2);
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), 3);
        assertFalse(itr.hasNext());
    }
}
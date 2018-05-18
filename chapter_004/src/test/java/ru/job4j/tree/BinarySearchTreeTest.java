package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests.
 */
public class BinarySearchTreeTest {

    @Test
    public void testSize() {
        BinarySearchTree testInstance = new BinarySearchTree(1);

        testInstance.add(35);
        testInstance.add(4);
        testInstance.add(104);

        int expectedValue = 4;
        int actualValue = testInstance.size();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWhenAdd4ElementsThenTreeContains4ElementsInSortedOrder() {
        BinarySearchTree testInstance = new BinarySearchTree(1);

        testInstance.add(35);
        testInstance.add(4);
        testInstance.add(104);

        List<Integer> listActualValues = testInstance.toList();
        assertEquals(1, (long) listActualValues.get(0));
        assertEquals(4, (long) listActualValues.get(1));
        assertEquals(35, (long) listActualValues.get(2));
        assertEquals(104, (long) listActualValues.get(3));
    }

    @Test
    public void testWhenAdd1000ElementsThenTreeContainsElementsInSortedOrder() {
        final Random random = new Random();
        BinarySearchTree testInstance = new BinarySearchTree(1);

        for (int i = 0; i < 1000; i++) {
            testInstance.add(random.nextInt(1000));
        }

        List<Integer> listActualValues = testInstance.toList();

        int buffer = listActualValues.get(0);
        for (int i = 1; i < listActualValues.size(); i++) {
            int current = listActualValues.get(i);
            assertTrue(buffer < current);
        }
    }

    @Test
    public void testIterator() {
        BinarySearchTree testInstance = new BinarySearchTree(1);

        testInstance.add(35);
        testInstance.add(4);
        testInstance.add(104);

        Iterator testIterator = testInstance.iterator();
        assertTrue(testIterator.hasNext());
        assertEquals(1, testIterator.next());
        assertTrue(testIterator.hasNext());
        assertEquals(4, testIterator.next());
        assertTrue(testIterator.hasNext());
        assertEquals(35, testIterator.next());
        assertTrue(testIterator.hasNext());
        assertEquals(104, testIterator.next());
        assertFalse(testIterator.hasNext());
    }

}
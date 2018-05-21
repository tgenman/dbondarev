package ru.job4j.exchange;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Test Request class.
 */
public class RequestTest {

    @Test
    public void testCompareTo() {
        TreeSet<Request> testInstance = new TreeSet<>();

        testInstance.add(new Request("MIT", Request.Type.ADD, Request.Action.ASK, 300, 10));
        testInstance.add(new Request("MIT", Request.Type.ADD, Request.Action.ASK, 324, 15));
        testInstance.add(new Request("MIT", Request.Type.ADD, Request.Action.ASK, 1700, 14));
        testInstance.add(new Request("MIT", Request.Type.ADD, Request.Action.ASK, 45, 13));
        testInstance.add(new Request("MIT", Request.Type.ADD, Request.Action.ASK, 440, 16));

        Iterator<Request> testIterator = testInstance.iterator();
        assertEquals(1700, testIterator.next().getPrice());
        assertEquals(440, testIterator.next().getPrice());
        assertEquals(324, testIterator.next().getPrice());
        assertEquals(300, testIterator.next().getPrice());
        assertEquals(45, testIterator.next().getPrice());
    }

}
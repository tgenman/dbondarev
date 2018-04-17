//package ru.job4j.list;
//
//import org.junit.Test;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.*;
//
///**
// * Created by tgenman on 4/13/18.
// */
//public class SimpleQueueTest {
//
//	/**
//	 * Test 1.
//	 */
//	@Test
//	public void testPush() {
//		SimpleQueue simpleQueue = new SimpleQueue();
//		simpleQueue.push(2);
//		simpleQueue.push(3);
//		simpleQueue.push(7);
//
//		assertThat(simpleQueue.size(), is(3));
//
//	}
//
//	/**
//	 * Test 2.
//	 */
//	@Test
//	public void testPoll() {
//		SimpleQueue simpleQueue = new SimpleQueue();
//		simpleQueue.push(2);
//		simpleQueue.push(3);
//		simpleQueue.push(7);
//		simpleQueue.push(9);
//
//		System.out.println(simpleQueue.poll());
//		System.out.println(simpleQueue.poll());
//		System.out.println(simpleQueue.poll());
//
////		assertThat(simpleQueue.poll(), is(2));
////		assertThat(simpleQueue.poll(), is(3));
////		assertThat(simpleQueue.poll(), is(7));
//	}
//
//}
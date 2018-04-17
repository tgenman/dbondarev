//package ru.job4j.list;
//
//import org.junit.Test;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//
///**
// * Created by tgenman on 4/13/18.
// */
//public class SimpleStackTest {
//
//	/**
//	 * Test 1.
//	 */
//	@Test
//	public void testPush() {
//		SimpleStack simpleStack = new SimpleStack();
//		simpleStack.push(2);
//		simpleStack.push(3);
//		simpleStack.push(7);
//
//		assertThat(simpleStack.size(), is(3));
//
//	}
//
//	/**
//	 * Test 2.
//	 */
//	@Test
//	public void testPoll() {
//		SimpleStack simpleStack = new SimpleStack();
//		simpleStack.push(2);
//		simpleStack.push(3);
//		simpleStack.push(7);
//
//		System.out.println(simpleStack.poll());
//		System.out.println("1df");
//		System.out.println(simpleStack.poll());
//		System.out.println(simpleStack.poll());
//
////		assertThat(simpleStack.poll(), is(7));
////		assertThat(simpleStack.poll(), is(3));
////		assertThat(simpleStack.poll(), is(2));
//	}
//}
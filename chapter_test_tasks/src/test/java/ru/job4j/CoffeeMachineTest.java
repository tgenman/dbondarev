package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by tgenman on 3/26/18.
 */
public class CoffeeMachineTest {

	/**
	 * Test to changes.
	 */
	@Test
	public void whenInput50and35ThenOutputRightArray() {
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		int[] expectedResult = new int[] {10, 5};
		int[] result = coffeeMachine.changes(50, 35);
		assertArrayEquals(result, expectedResult);
	}
}

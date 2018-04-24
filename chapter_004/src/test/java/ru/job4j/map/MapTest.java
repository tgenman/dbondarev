package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tgenman on 4/21/18.
 */
public class MapTest {

	/**
	 * Test dont overrided equals and hashCode.
	 */
	@Test
	public void whenEqualsAndHashCodeDontOverride() {
		UserOne one = new UserOne("Ivan", 3);
		UserOne two = new UserOne("Ivan", 3);
		Map<UserOne, Object> testInstance = new HashMap<>();
		testInstance.put(one, 1);
		testInstance.put(two, 2);
		System.out.println(testInstance);
	}

	/**
	 * Test dont overrided equals and override hashCode.
	 */
	@Test
	public void whenEqualsDontOverrideAndHashCodeOverride() {
		UserTwo one = new UserTwo("Ivan", 3);
		UserTwo two = new UserTwo("Ivan", 3);
		Map<UserTwo, Object> testInstance = new HashMap<>();
		testInstance.put(one, 1);
		testInstance.put(two, 2);
		System.out.println(testInstance);
	}

	/**
	 * Test override equals and don't override hashCode.
	 */
	@Test
	public void whenEqualsOverrideAndHashCodeDontOverride() {
		UserThree one = new UserThree("Ivan", 3);
		UserThree two = new UserThree("Ivan", 3);
		Map<UserThree, Object> testInstance = new HashMap<>();
		testInstance.put(one, 1);
		testInstance.put(two, 2);
		System.out.println(testInstance);
	}

	/**
	 * Test override equals and hashCode.
	 */
	@Test
	public void whenEqualsAndHashCodeOverride() {
		UserFour one = new UserFour("Ivan", 3);
		UserFour two = new UserFour("Ivan", 3);
		Map<UserFour, Object> testInstance = new HashMap<>();
		testInstance.put(one, 1);
		testInstance.put(two, 2);
		System.out.println(testInstance);
	}
}

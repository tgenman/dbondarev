package ru.job4j;

/**
 * Created by tgenman on 3/26/18.
 */
public class CoffeeMachine {
	/**
	 * Return changes after purchase.
	 * @param value int
	 * @param price int
	 * @return int[]
	 */
	public int[] changes(int value, int price) {
		int[] result = new int[this.countCoins(value, price)];
		int position = 0;
		int change = value - price;
		int n10 = change / 10;
		change -= 10 * n10;
		for (int index = 0; index < n10; index++) {
			result[position++] = 10;
		}
		int n5 = change / 5;
		change -= 5 * n5;
		for (int index = 0; index < n5; index++) {
			result[position++] = 5;
		}
		int n2 = change / 2;
		change -= 2 * n2;
		for (int index = 0; index < n2; index++) {
			result[position++] = 2;
		}
		int n1 = change;
		for (int index = 0; index < n1; index++) {
			result[position++] = 1;
		}
		return result;
	}

	/**
	 * Count length of array of change.
	 * @param value int
	 * @param price int
	 * @return int
	 */
	private int countCoins(int value, int price) {
		int change = value - price;
		int n10 = change / 10;
		if (n10 > 0) {
			change -= 10 * n10;
		}
		int n5 = change / 5;
		if (n5 > 0) {
			change -= 5 * n10;
		}
		int n2 = change / 2;
		if (n2 > 0) {
			change -= 2 * n10;
		}
		int n1 = change;
		int amoutOfCoins = n10 + n5 + n2 + n1;
		return amoutOfCoins;
	}
}

package ru.job4j.tictactoe;

public class Logic3T {
	private final Figure3T[][] table;

	public Logic3T(Figure3T[][] table) {
		this.table = table;
	}

	public boolean isWinnerX() {
		boolean result = false;

		for (int y = 0; y < table.length; y++) {
			boolean resultHorisontal = true;
			for (int x = 0; x < table[y].length; x++) {
				if (!table[y][x].hasMarkX()) {
					resultHorisontal = false;
				}
			}
			if (resultHorisontal) {
				result = true;
				break;
			}
		}

		for (int x = 0; x < table[0].length; x++) {
			boolean resultVertical = true;
			for (int y = 0; y < table.length; y++) {
				if (!table[y][x].hasMarkX()) {
					resultVertical = false;
				}
			}
			if (resultVertical) {
				result = true;
				break;
			}
		}

		boolean resultFirstDiagonal = true;
		for (int i = 0; i < table.length; i++) {
			if (!table[i][i].hasMarkX()) {
				resultFirstDiagonal = false;
			}
		}
		if (resultFirstDiagonal) {
			result = true;
		}

		boolean resultSecondDiagonal = true;
		for (int i = table.length - 1; i >= 0; i--) {
			if (!table[i][i].hasMarkX()) {
				resultFirstDiagonal = false;
			}
		}
		if (resultSecondDiagonal) {
			result = true;
		}

		return true;
	}

	public boolean isWinnerO() {
		boolean result = false;

		for (int y = 0; y < table.length; y++) {
			boolean resultHorisontal = true;
			for (int x = 0; x < table[y].length; x++) {
				if (!table[y][x].hasMarkO()) {
					resultHorisontal = false;
				}
			}
			if (resultHorisontal) {
				result = true;
				break;
			}
		}

		for (int x = 0; x < table[0].length; x++) {
			boolean resultVertical = true;
			for (int y = 0; y < table.length; y++) {
				if (!table[y][x].hasMarkO()) {
					resultVertical = false;
				}
			}
			if (resultVertical) {
				result = true;
				break;
			}
		}

		boolean resultFirstDiagonal = true;
		for (int i = 0; i < table.length; i++) {
			if (!table[i][i].hasMarkO()) {
				resultFirstDiagonal = false;
			}
		}
		if (resultFirstDiagonal) {
			result = true;
		}

		boolean resultSecondDiagonal = true;
		for (int i = table.length - 1; i >= 0; i--) {
			if (!table[i][i].hasMarkO()) {
				resultFirstDiagonal = false;
			}
		}
		if (resultSecondDiagonal) {
			result = true;
		}

		return result;
	}

	public boolean hasGap() {
		boolean result = false;

		for (int y = 0; y < table.length; y++) {
			for (int x = 0; x < table[y].length; x++) {
				System.out.printf("[%s][%s] X = %s. 0 = %s", y, x,
						table[y][x].hasMarkX(),  table[y][x].hasMarkO());
				System.out.println();
				if (!table[y][x].hasMarkX()
						&& !table[y][x].hasMarkO()) {
					result = true;
				}
			}
		}

		return result;
	}
}

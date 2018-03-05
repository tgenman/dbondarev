package ru.job4j.start;

import ru.job4j.tracker.MenuOutException;

/**
 * Imitation of user's input.
 */
public class StubInput implements Input {
	/** Array of answers. */
	private String[] answers;
	/** Current index in answer's array. */
	private int position = 0;

	/**
	 * Constructor with array of user's answers.
	 * @param answers array of user's answers
	 */
	public StubInput(String[] answers) {
		this.answers = answers;
	}

	/**
	 * Implementation of interface.
	 * @param question String
	 * @return Stub answer from array
	 */
	@Override
	public String ask(String question) {
		return answers[position++];
	}

	@Override
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (key == value) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range");
		}
	}
}
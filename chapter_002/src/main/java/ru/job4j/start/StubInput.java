package ru.job4j.start;

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
}

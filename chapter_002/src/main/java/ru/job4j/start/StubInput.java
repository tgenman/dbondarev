package ru.job4j.start;

/**
 * Class of Stub Input.
 */
public class StubInput implements Input {
    /** Array String of answers. */
    private String[] answers;
    /** Pointer to Array of answers. */
    private int position = 0;

    /**
     * Constructor.
     * @param answers String[]
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Ask.
     * @param question String
     * @return String
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }
}

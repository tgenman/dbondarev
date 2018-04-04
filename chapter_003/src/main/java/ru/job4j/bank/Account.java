package ru.job4j.bank;

/**
 * Created by tgenman on 4/4/18.
 */
public class Account {
	/** Value. */
	private double value;

	/** requisites. */
	private final String requisites;

	/**
	 * Constructor.
	 * @param value int
	 * @param requisites String
	 */
	public Account(int value, String requisites) {
		this.value = value;
		this.requisites = requisites;
	}

	/**
	 * Getter.
	 * @return double
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Getter requsites.
	 * @return String
	 */
	public String getRequisites() {
		return requisites;
	}

	/**
	 * Setter Value.
	 * @param value double
	 */
	public void setValue(double value) {
		this.value = value;
	}
}

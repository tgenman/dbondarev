package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by tgenman on 4/4/18.
 */
public class BankDataBaseTest {

	/**
	 * Test Add.
	 */
	@Test
	public void whenAddUserThenBankContainsUser() {
		User one = new User("Alfa", "Omega");
		BankDataBase bankDataBase = new BankDataBase();
		bankDataBase.addUser(one);
		assertThat(bankDataBase.containsUser(one), is(true));
	}

	/**
	 * Test Remove.
	 */
	@Test
	public void whenRemoveUserThenBankNotContainsUser() {
		User one = new User("Alfa", "Omega");
		BankDataBase bankDataBase = new BankDataBase();
		bankDataBase.addUser(one);
		assertThat(bankDataBase.containsUser(one), is(true));
		bankDataBase.deleteUser(one);
		assertThat(bankDataBase.containsUser(one), is(false));
	}

	/**
	 * Test Add Account To User.
	 */
	@Test
	public void whenAddAccountToUserThenUserHaveNewAccount() {
		User one = new User("Alfa", "Omega");
		BankDataBase bankDataBase = new BankDataBase();
		bankDataBase.addUser(one);
		Account input = new Account(50, "12345");
		bankDataBase.addAccountToUser(one.getPassport(), input);

		List<Account> result = bankDataBase.getUserAccounts(one.getPassport());
		assertThat(result.get(0).getRequisites(), is(input.getRequisites()));
	}

	/**
	 * Test Delete Account To User.
	 */
	@Test
	public void whenDeleteAccountToUserThenUserHaveNotAccount() {
		User one = new User("Alfa", "Omega");
		BankDataBase bankDataBase = new BankDataBase();
		bankDataBase.addUser(one);
		Account input = new Account(50, "12345");
		bankDataBase.addAccountToUser(one.getPassport(), input);

		List<Account> result = bankDataBase.getUserAccounts(one.getPassport());
		assertThat(result.get(0).getRequisites(), is(input.getRequisites()));

		bankDataBase.deleteAccountFromUser(one.getPassport(), input);
		result = bankDataBase.getUserAccounts(one.getPassport());
		assertThat(result.size(), is(0));
	}

	/**
	 * Test Transfer money and value not enought.
	 */
	@Test
	public void whenTransferMonetAndValueNotEnoughtThenFalse() {
		BankDataBase bankDataBase = new BankDataBase();
		User one = new User("Alfa", "Omega");
		User two = new User("Psi", "Gamma");
		Account oneOne = new Account(50, "12345");
		Account twoOne = new Account(10, "67891");

		bankDataBase.addUser(one);
		bankDataBase.addUser(two);
		bankDataBase.addAccountToUser(one.getPassport(), oneOne);
		bankDataBase.addAccountToUser(two.getPassport(), twoOne);

		boolean result = bankDataBase.transferMoney(one.getPassport(),
				oneOne.getRequisites(),
				two.getPassport(),
				twoOne.getRequisites(),
				60);
		assertThat(result, is(false));
	}

	/**
	 * Test Transfer money and true.
	 */
	@Test
	public void whenTransferMonetAndValueThenTrue() {
		BankDataBase bankDataBase = new BankDataBase();
		User one = new User("Alfa", "Omega");
		User two = new User("Psi", "Gamma");
		Account oneOne = new Account(50, "12345");
		Account twoOne = new Account(10, "67891");

		bankDataBase.addUser(one);
		bankDataBase.addUser(two);
		bankDataBase.addAccountToUser(one.getPassport(), oneOne);
		bankDataBase.addAccountToUser(two.getPassport(), twoOne);

		boolean result = bankDataBase.transferMoney(one.getPassport(),
				oneOne.getRequisites(),
				two.getPassport(),
				twoOne.getRequisites(),
				40);
		assertThat(result, is(true));
	}
}

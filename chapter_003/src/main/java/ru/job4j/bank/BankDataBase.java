package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tgenman on 4/4/18.
 */
public class BankDataBase {
	/** Container. */
	private final Map<User, List<Account>> dataBase = new HashMap<>();

	/**
	 * Add User.
	 * @param user User
	 */
	public void addUser(User user) {
		this.dataBase.put(user, new ArrayList<>());
	}

	/**
	 * Delete User.
	 * @param user User
	 */
	public void deleteUser(User user) {
		this.dataBase.remove(user);
	}

	/**
	 * Contains User.
	 * @param user User
	 * @return boolean
	 */
	public boolean containsUser(User user) {
		return this.dataBase.containsKey(user);
	}

	/**
	 * Add Account To User.
	 * @param passport String
	 * @param account Account
	 */
	public void addAccountToUser(String passport, Account account) {
		for (User user : this.dataBase.keySet()) {
			if (user.getPassport().equals(passport)) {
				this.dataBase.get(user).add(account);
			}
		}
	}

	/**
	 * Delete Account From User.
	 * @param passport String
	 * @param account Account
	 */
	public void deleteAccountFromUser(String passport, Account account) {
		for (User user : this.dataBase.keySet()) {
			if (user.getPassport().equals(passport)) {
				this.dataBase.get(user).remove(account);
			}
		}
	}

	/**
	 * Get User Accounts.
	 * @param passport String
	 * @return List
	 */
	public List<Account> getUserAccounts(String passport) {
		List<Account> result = null;
		for (User user : this.dataBase.keySet()) {
			if (user.getPassport().equals(passport)) {
				result = this.dataBase.get(user);
			}
		}
		return result;
	}

	/**
	 * Transfer Money.
	 * @param srcPassport String
	 * @param srcRequisite String
	 * @param destPassport String
	 * @param dstRequisite String
	 * @param amount double
	 * @return boolean
	 */
	public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
		Account source = findAccountByPassportAndRequisite(srcPassport, srcRequisite);
		Account destination = findAccountByPassportAndRequisite(destPassport, dstRequisite);
		return transferFromTo(source, destination, amount);
	}

	/**
	 * Transfer From To.
	 * @param source Account
	 * @param destination Account
	 * @param amount double
	 * @return boolean
	 */
	private boolean transferFromTo(Account source, Account destination, double amount) {
		if (source == null) {
			return false;
		}
		if (destination == null) {
			return false;
		}
		if (source.getValue() < amount) {
			return false;
		}
		source.setValue(source.getValue() - amount);
		destination.setValue(destination.getValue() + amount);
		return true;
	}

	/**
	 * Find Account By Passport And Requisite.
	 * @param passport String
	 * @param requisite String
	 * @return Account
	 */
	private Account findAccountByPassportAndRequisite(String passport, String requisite) {
		Account result = null;
		for (User user : this.dataBase.keySet()) {
			if (user.getPassport().equals(passport)) {
				for (Account acc : this.dataBase.get(user)) {
					if (acc.getRequisites().equals(requisite)) {
						result = acc;
					}
				}
			}
		}
		return result;
	}
}


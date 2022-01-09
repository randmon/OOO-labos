package v2.domain;

import java.util.ArrayList;

import static v2.domain.BankEvent.*;

public class Bank extends Observable {
    private final ArrayList<Account> accounts;
    private String lastDeposit, lastWithdrawal;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(int number, double balance) {
        accounts.add(new Account(number, balance));
        notifyObservers(ADD_ACCOUNT);
    }

    public int getAmountOfAccounts() {
        return getAccounts().size();
    }

    public Account getLastAccount() {
        return accounts.get(accounts.size()-1);
    }

    public Account getByNumber(int accountNnumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNnumber) {
                return account;
            }
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        if (amount < 0) throw new IllegalArgumentException("Invalid amount");

        Account account = getByNumber(accountNumber);
        if (account == null) throw new IllegalArgumentException("Account is not in this bank");

        account.setBalance(account.getBalance() + amount);
        lastDeposit = "New deposit on account: " + accountNumber + ", amount: " + amount + ", new balance: " + account.getBalance();
        notifyObservers(DEPOSIT);
    }

    public String getLastDeposit() {
        return lastDeposit;
    }

    public void withdrawal(int accountNumber, int amount) {
        if (amount < 0) throw new IllegalArgumentException("Invalid amount");

        Account account = getByNumber(accountNumber);
        if (account == null) throw new IllegalArgumentException("Account is not in this bank");

        double newBalance = account.getBalance() - amount;
        if (newBalance < 0) throw new IllegalArgumentException("Not enough money on this account");
        account.setBalance(newBalance);
        lastWithdrawal = "New withdrawal on account: " + accountNumber + ", amount: " + amount + ", new balance: " + newBalance;
        notifyObservers(WITHDRAWAL);
    }

    public String getLastWithdrawal() {
        return lastWithdrawal;
    }
}

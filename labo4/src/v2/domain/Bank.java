package v2.domain;

import java.util.ArrayList;
import java.util.Observable;

public class Bank extends Observable {
    private ArrayList<Account> accounts;
    private String lastDeposit, lastWithdrawal;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        setChanged();
        notifyObservers("account");
    }

    public void addAccount(int number, double balance) {
        addAccount(new Account(number, balance));
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
        setChanged();
        notifyObservers("deposit");
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
        setChanged();
        notifyObservers("withdrawal");
    }

    public String getLastWithdrawal() {
        return lastWithdrawal;
    }
}

package v1.domain;

import java.util.ArrayList;

public class Bank extends Subject {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        this.notifyAllObservers();
    }

    public void addAccount(int number, double saldo) {
        addAccount(new Account(number, saldo));
    }

    public int getAmountOfAccounts() {
        return getAccounts().size();
    }

    public Account getLastAccount() {
        return accounts.get(accounts.size()-1);
    }
}

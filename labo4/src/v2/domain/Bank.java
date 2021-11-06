package v2.domain;

import v1.domain.Account;

import java.util.ArrayList;
import java.util.Observable;

public class Bank extends Observable {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        this.setChanged();
        this.notifyObservers();
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

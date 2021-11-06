package v1.domain.observers;

import v1.domain.Bank;

public class AccountLogger implements Observer {
    private Bank bank;

    public AccountLogger(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void update() {
        System.out.println("Nr: " + bank.getLastAccount().getAccountNumber() + ", total: " + bank.getAmountOfAccounts());
    }
}

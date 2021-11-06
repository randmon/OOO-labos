package v2.domain.observers;

import v2.domain.Bank;

import java.util.Observable;
import java.util.Observer;

public class AccountLogger implements Observer {
    private Bank bank;

    public AccountLogger(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void update(Observable o, Object arg) {
        switch ((String) arg) {
            case "account" -> logAccount();
            case "deposit" -> logDeposit();
            case "withdrawal" -> logWithdrawal();
        }
    }

    private void logWithdrawal() {
        System.out.println(bank.getLastWithdrawal());
    }

    private void logDeposit() {
        System.out.println(bank.getLastDeposit());
    }

    private void logAccount() {
        System.out.println("Nr: " + bank.getLastAccount().getAccountNumber() + ", total: " + bank.getAmountOfAccounts() + " account(s)");
    }
}

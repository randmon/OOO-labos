package v2.domain.observers;

import v2.domain.Bank;
import v2.domain.BankEvent;

public class AccountLogger implements Observer {
    private final Bank bank;

    public AccountLogger(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void update(BankEvent event) {
        switch (event) {
            case ADD_ACCOUNT -> logAccount();
            case DEPOSIT -> logDeposit();
            case WITHDRAWAL -> logWithdrawal();
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

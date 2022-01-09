package v2.domain.observers;

import v2.domain.Bank;
import v2.domain.BankEvent;

import java.time.LocalDate;

import static v2.domain.BankEvent.ADD_ACCOUNT;

public class Auditor implements Observer {
    private final Bank bank;

    public Auditor(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void update(BankEvent event) {
        if (event.equals(ADD_ACCOUNT)) {
        System.out.println("New account opened on " + LocalDate.now() +
                " with nr. " + bank.getLastAccount().getAccountNumber() +
                " and balance " + bank.getLastAccount().getBalance());
        }
    }
}

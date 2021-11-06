package v2.domain.observers;

import v2.domain.Bank;

import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;

public class Auditor implements Observer {
    private Bank bank;

    public Auditor(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("account")) {
        System.out.println("New account opened on " + LocalDate.now() +
                " with nr. " + bank.getLastAccount().getAccountNumber() +
                " and balance " + bank.getLastAccount().getBalance());

        }
    }
}

package v1.ui;

import v1.domain.Bank;
import v1.domain.observers.AccountLogger;
import v1.domain.observers.Auditor;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Auditor auditor = new Auditor(bank);
        bank.addObserver(auditor);
        bank.addObserver(new AccountLogger(bank));
        bank.addAccount(123, 100);

        bank.removeObserver(auditor);
        bank.addAccount(400, 9999);
    }
}

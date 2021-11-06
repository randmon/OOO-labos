package v2.ui;

import v2.domain.Bank;
import v2.domain.observers.AccountLogger;
import v2.domain.observers.Auditor;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Auditor auditor = new Auditor(bank);
        bank.addObserver(auditor);
        bank.addObserver(new AccountLogger(bank));
        bank.addAccount(123, 100);

        bank.deleteObserver(auditor);
        bank.addAccount(400, 9999);
    }
}

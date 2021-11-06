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
        bank.addAccount(111, 100);
        nL();
        bank.addAccount(444, 9999);
        bank.deposit(444, 1);
        nL();
        bank.deposit(111, 12345);
        bank.withdrawal(111, 12340);
    }

    private static void nL() {
        System.out.println("----");
    }
}

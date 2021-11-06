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
        System.out.println("Nieuwe rekening geopend op datum " + LocalDate.now() +
                " met nummer " + bank.getLastAccount().getAccountNumber() +
                " en saldo " + bank.getLastAccount().getSaldo());
    }
}

package v1.domain.observers;

import v1.domain.Bank;

import java.time.LocalDate;

public class Auditor implements Observer {
    private final Bank bank;

    public Auditor(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void update() {
        System.out.println("Nieuwe rekening geopend op datum " + LocalDate.now() +
                " met nummer " + bank.getLastAccount().getAccountNumber() +
                " en saldo " + bank.getLastAccount().getSaldo());
    }
}

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
        System.out.println("logger");
    }
}

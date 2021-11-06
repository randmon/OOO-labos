package v1.domain;

public class Account {
    private int accountNumber;
    private double saldo;

    public Account(int accountNumber, double saldo) {
        setAccountNumber(accountNumber);
        setSaldo(saldo);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) throw new IllegalArgumentException("Saldo cannot be negative");
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountNumber != account.accountNumber) return false;
        return Double.compare(account.saldo, saldo) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNumber;
        temp = Double.doubleToLongBits(saldo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

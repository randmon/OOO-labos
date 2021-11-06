package v2.domain;

public class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountNumber != account.accountNumber) return false;
        return Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNumber;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

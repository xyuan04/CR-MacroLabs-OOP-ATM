public abstract class Account {
    private final Integer accountNumber;
    private double balance;

    protected Account(Integer accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double withdraw(double amount) {
        if (balance > amount && balance - amount >= 0) {
            balance -= amount;
        }
        return balance;
    }

    public double deposit(double amount) {
        return balance + amount;
    }


}

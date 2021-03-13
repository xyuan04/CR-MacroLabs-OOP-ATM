public class Investment extends Account {

    public Investment(Integer accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double transferToSavings(Savings savingsAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            savingsAccount.deposit(transferAmount);
        }

        return this.getBalance();
    }

    public double transferToChecking(Checking checkingAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            checkingAccount.deposit(transferAmount);
        }

        return this.getBalance();
    }
}

/*public class Savings {
}
public class Savings extends Account{

    public Savings(Integer accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double transferToChecking(Checking checkingAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            checkingAccount.deposit(transferAmount);
        }

        return this.getBalance();
    }

    public double transferToInvestment(Investment investmentAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            investmentAccount.deposit(transferAmount);
        }

        return this.getBalance();
    }
}*/
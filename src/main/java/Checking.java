/*public class Checking extends Account{

    public Checking(Integer accountNumber, double balance) {
        super(accountNumber,balance);
    }

    public void transferToSavings(Savings savingsAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            savingsAccount.deposit(transferAmount);
        }

        //return this.getBalance();
    }

    public void transferToInvestment(Investment investmentAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            investmentAccount.deposit(transferAmount);
        }
    }
}*/
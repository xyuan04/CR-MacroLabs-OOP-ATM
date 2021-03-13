public class Savings extends Account{

    public Savings(Integer accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double transferToChecking(Checking checkingAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            checkingAccount.deposit(transferAmount);
        }
        else System.out.println("Non sufficient funds");

        return this.getBalance();
    }

    public double transferToInvestment(Investment investmentAccount, double transferAmount) {
        if (this.getBalance() > transferAmount && this.getBalance() - transferAmount >= 0) {
            this.withdraw(transferAmount);
            investmentAccount.deposit(transferAmount);
        }
        else System.out.println("Non sufficient funds");

        return this.getBalance();
    }
}

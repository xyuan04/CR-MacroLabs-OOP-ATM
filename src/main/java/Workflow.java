public class Workflow {

    Display d;
    Console c;
    String lastAction;
    Double lastAmount;

    public Workflow(){
        d = new Display();
        c = new Console();
        lastAction = "";
        lastAmount = 0.0;
    }

    public void errorSP(){
        d.currentDisplaySP("\nImproper input. Please reread instructions.\n");
    }

    public void initialWelcomeSP(){
        d.currentDisplaySP("Welcome to the ATM! Are you a new or returning user?\nEnter 1 for new, 2 for returning.");
    }

    public Integer getInput(){
        return c.getIntegerInput("Enter your input:");
    }



    //include input for customername

    //initial opening of an account + deposit. double and string

    public void newUserSP(){
        d.currentDisplaySP("Input your username, then password twice, or type one lowercase x now to cancel.");
    }

    public void passwordMismatchSP(){
        d.currentDisplaySP("Passwords do not match. Please try again.");
    }

    public void returningUserSP(){
        d.currentDisplaySP("Input your username, then password, or type one lowercase x now to cancel.");
    }

    public String getUserSP(){
        String middleMan = c.getStringInput("Enter username:");
        d.setTransactionHistory("History of user " + middleMan + "\n");
        return middleMan;
    }

    public String getPassSP(){
        return c.getStringInput("Enter password:");
    }

    public String getNameSP(){
        return "";
    }

    public void initialAccountOpen(){
        //user input double and string
    }



    public void mainMenuSP(Customer customer){
        d.currentDisplaySP("Welcome, " + customer.getCustomerName() + "! What do you want to do?\nEnter 1 to check balance\t\t\t\tEnter 2 to transfer\nEnter 3 to withdraw\t\t\t\t\t\tEnter 4 to deposit\nEnter 5 to open a new account\t\t\tEnter 6 to close an account\nEnter 7 to print transaction history\tEnter 8 to log out");
    }



    public int enterAccount(){
        return c.getIntegerInput("Enter an account:");
    }

    public void checkPromptSP(){
        d.currentDisplaySP("What account do you want to check?");
    }

    public void checkResultSP(Account account){
        d.currentDisplaySP("Your account's current balance is " + account.getBalance());
    }



    public void withdrawPromptSP(){
        d.currentDisplaySP("What account do you want to withdraw from?");
        lastAction = " withdrawn from ";
    }

    public void depositPromptSP(){
        d.currentDisplaySP("What account do you want to deposit into?");
        lastAction = " deposited into ";
    }

    public void transferPromptSP(){
        d.currentDisplaySP("What accounts do you want to transfer from and to?");
        lastAction = " transferred to ";
    }

    public Double amountPromptSP(){
        //try catch
        lastAmount = c.getDoubleInput("How much?");
        return lastAmount;
    }

    public void completeResultSP(Account account){
        d.currentDisplaySP("Action performed successfully.\n");
        d.addToTransactionHistory("$" + lastAmount + lastAction + "account #" + account.getAccountNumber());
    }

    public void completeResultSP(Account account1, Account account2){
        d.currentDisplaySP("Action performed successfully.\n");
        d.addToTransactionHistory("$" + lastAmount + lastAction + "account #" + account1.getAccountNumber() + " to account #" + account2.getAccountNumber() + "\n");
    }

    public void completeResultsNoHistorySP(){
        d.currentDisplaySP("Action performed successfully.\n");
    }



    public String openPrompt(){
        return c.getStringInputNotCaseSensitive("What kind of account do you want to open?");
    }

    public void closePrompt(){
        d.currentDisplaySP("What account do you want to close?\nNOTE: The account must be empty.");
    }

    public void printHistory(){
        d.printTransactionHistory();
    }



    public void logOutSP(){
        d.currentDisplaySP("Thank you for your business.");
        d.setTransactionHistory("");
    }

}

public class Workflow {

    Display d;
    Console c;

    public Workflow(){
        d = new Display();
        c = new Console();
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
        return c.getStringInput("Enter username:");
    }

    public String getPassSP(){
        return c.getStringInput("Enter password:");
    }



    public void mainMenuSP(Customer customer){
        d.currentDisplaySP("Welcome, " + customer.getUserName() + "! What do you want to do?\nEnter 1 to check balance\t\t\t\tEnter 2 to transfer\nEnter 3 to withdraw\t\t\t\t\t\tEnter 4 to deposit\nEnter 5 to open a new account\t\t\tEnter 6 to close an account\nEnter 7 to print transaction history\tEnter 8 to log out");
    }



    public String enterAccount(){
        return c.getStringInputNotCaseSensitive("Enter an account:");
    }

    public void checkPromptSP(){
        d.currentDisplaySP("What account do you want to check?");
    }

    public void withdrawPromptSP(){
        d.currentDisplaySP("What account do you want to withdraw from?");
    }

    public void depositPromptSP(){
        d.currentDisplaySP("What account do you want to deposit into?");
    }

    public void transferPromptSP(){
        d.currentDisplaySP("What accounts do you want to transfer from and to?");
    }

    public String openPrompt(){
        return c.getStringInputNotCaseSensitive("What kind of account do you want to open?");
    }

    public void closePromptSP(){
        d.currentDisplaySP("What account do you want to close?\nNOTE: The account must be empty.");
    }

}

public class Workflow {

    Display d;
    Console c;

    public Workflow(){
        d = new Display();
        c = new Console();
    }

    public void errorSP(){
        d.currentDisplaySP("Improper input. Please reread instructions.");
    }

    public Integer initialWelcomeSP(){
        d.currentDisplaySP("Welcome to the ATM! Are you a new or returning user?");
        return c.getIntegerInput("Enter 1 for new, 2 for returning:");
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

    public String getaPassSP(){
        return c.getStringInput("Enter password:");
    }



    public void mainMenuSP(Customer customer){

    }

}

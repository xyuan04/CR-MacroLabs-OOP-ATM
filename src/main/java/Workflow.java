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
        return c.getIntegerInput("Enter 1 for new, 2 for returning");
    }



}

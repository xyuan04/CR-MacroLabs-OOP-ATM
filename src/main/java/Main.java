/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        Workflow w = new Workflow();

        Account acct = new Savings(12, 34.0);
        Account[] accts = new Account[1];
        accts[0] = acct;
        Customer customer = new Customer("Hazel", "HD", "45", accts);

        String user = w.getUserSP();
        w.mainMenuSP(customer);
        w.withdrawPromptSP();
        Double dub1 = w.amountPromptSP();
        w.completeResultSP(accts[0]);
        w.printHistory();
    }

    public void runEngine(){
        Workflow screen = new Workflow();

        Account acct = new Savings(12, 34.0);
        Account[] accts = new Account[1];
        accts[0] = acct;
        Customer customer = new Customer("Hazel", "HD", "45", accts);

        //Starting screen
        screen.initialWelcomeSP();
        //1 for new user, 2 for returning. this /just/ takes the number tho
        screen.getInput();

        //path 1
        //prompts new user for the necessary info
        //name
        screen.getNameSP();
        //username
        screen.getUserSP();
        //enter password twice. check to see if they match
        screen.getPassSP();
        screen.getPassSP();
        //initial deposit
        screen.initialAccountOpen();

        //path 2
        //prompts returning user for the necessary info
        //username
        screen.getUserSP();
        //password, in while loop, which will kick user out if they fail three times
        screen.getPassSP();



        //after the user has either been made or logged in we print the main menu
        screen.mainMenuSP(customer);

        //switch statement for each option on the main menu

        //1
        //prints out "Which acct?"
        screen.checkPromptSP();
        //The user enters which acct type
        screen.enterAccount();
        //Depending on which acct type they enter, this checks the balance of that account
        screen.checkResultSP(accts[0]);

        //2
        //prints out "Which acct?"
        screen.transferPromptSP();
        //The user enters "from", then "to"
        screen.enterAccount();
        screen.enterAccount();
        //there needs to be code in here that actually transfers the money
        //print out "action performed successfully" and save it in transaction history
        //this needs 2 acct inputs, the from and to, to save it to history
        screen.completeResultSP(accts[0], accts[0]);

        //3
        //prints out "Which acct?"
        screen.withdrawPromptSP();
        //The users enter which acct is being withdrawn from
        screen.enterAccount();
        //there needs to be code in here that actually withdraws the money
        //print out "action performed successfully" and save it in transaction history
        //this needs 1 acct input to save it to history
        screen.completeResultSP(accts[0]);

        //4
        //prints out "Which acct?"
        screen.depositPromptSP();
        //The users enter which acct is being deposited to
        screen.enterAccount();
        //there needs to be code in here that actually deposits the money
        //print out "action performed successfully" and save it in transaction history
        //this needs 1 acct input to save it to history
        screen.completeResultSP(accts[0]);

        //5
        //"What kind of acct are you opening", takes a string
        screen.openPrompt();
        //code in here that does the thing

        //6
        //"Which acct are you closing"
        screen.closePrompt();
        //The user enters which acct to close
        screen.enterAccount();
        //code in here that does the thing

        //7
        //all 7 does is print transaction history, the fun stuff is in other methods
        screen.printHistory();

        //8
        //all 8 does is log out
        //take us back to the initial screen!



    }

    public void checkBalance(){
        Workflow screen = new Workflow();
        //prints out "Which acct?"
        screen.checkPromptSP();
        //The user enters which acct type
        screen.enterAccount();
        //Depending on which acct type they enter, this checks the balance of that account
        //screen.checkResultSP(acct);
    }



}

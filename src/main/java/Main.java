/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        Main test = new Main();
        Workflow screen = new Workflow();
        Customer xiong = new Customer("xiong", "dj", "gy", new Account[] {new Checking(100, 15000), new Savings(200, 25000), new Investment(300, 50000)});

        test.deposit(screen, xiong);
        test.withdrawal(screen, xiong);
        test.transfer(screen, xiong);
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



    public void check(Workflow screen, Customer customer){
        screen.checkPromptSP();

        while(true) {
            try {
                Integer acctNumber = screen.enterAccount();
                screen.checkResultSP(customer.getAccount(acctNumber));
                break;
            }
            catch(Exception e){
                screen.errorSP();
            }
        }
    }

    public void history(Workflow screen){
        screen.printHistory();
    }




    public void withdrawal(Workflow screen, Customer customer) {
        boolean validAmount = true;
        screen.withdrawPromptSP();

        Integer withdrawAccount = screen.enterAccount();
        while(customer.getAccount(withdrawAccount) == null) {
            System.out.println("Account not on file");
            withdrawAccount = screen.enterAccount();
        }

        while (validAmount) {
            double withdrawalAmount = screen.amountPromptSP();
            if (customer.getAccount(withdrawAccount).getBalance() > withdrawalAmount) {
                customer.getAccount(withdrawAccount).withdraw(withdrawalAmount);
                validAmount = false;
            } else System.out.println("Non sufficient funds");
        }

        System.out.println(customer.getAccount(withdrawAccount).getBalance());
        screen.completeResultSP(customer.getAccount(withdrawAccount));
    }

    public void deposit(Workflow screen, Customer customer) {
        screen.depositPromptSP();

        Integer depositAccount = screen.enterAccount();
        while(customer.getAccount(depositAccount) == null) {
            System.out.println("Account not on file");
            depositAccount = screen.enterAccount();
        }

        double depositAmount = screen.amountPromptSP();

        customer.getAccount(depositAccount).deposit(depositAmount);

        System.out.println(customer.getAccount(depositAccount).getBalance());
        screen.completeResultSP(customer.getAccount(depositAccount));
    }

    public void transfer(Workflow screen, Customer customer) {
        boolean validAmount = true;
        screen.transferPromptSP();

        Integer withdrawAccount = screen.enterAccount();
        while(customer.getAccount(withdrawAccount) == null) {
            System.out.println("Account not on file");
            withdrawAccount = screen.enterAccount();
        }

        Integer depositAccount = screen.enterAccount();
        while(customer.getAccount(depositAccount) == null) {
            System.out.println("Account not on file");
            depositAccount = screen.enterAccount();
        }

        while (validAmount) {
            double transferAmount = screen.amountPromptSP();
            if (customer.getAccount(withdrawAccount).getBalance() >= transferAmount) {
                customer.getAccount(withdrawAccount).withdraw(transferAmount);
                customer.getAccount(depositAccount).deposit(transferAmount);
                validAmount = false;
            } else System.out.println("Non sufficient funds");
        }

        System.out.println(customer.getAccount(withdrawAccount).getBalance());
        System.out.println(customer.getAccount(depositAccount).getBalance());
        screen.completeResultSP(customer.getAccount(withdrawAccount), customer.getAccount(depositAccount));
    }



}

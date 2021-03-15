public class Xiong {
    boolean engineOn = true;

    public static void main(String[] args) {
        Xiong test = new Xiong();
        Workflow screen = new Workflow();
        Customer xiong = Creator.createCustomer("xiong", "xyuan", "zipcode", new Checking(100, 1500), new Savings(1000, 2500), new Investment(10000, 6000));
        Customer mike = Creator.createCustomer("mike", "ninh", "zipcode", new Checking(101, 1500), new Savings(1001, 2500), new Investment(10001, 6000));
        Customer hazel = Creator.createCustomer("hazel", "hbecker", "zipcode", new Checking(102, 1500), new Savings(1002, 2500), new Investment(10002, 6000));
        Customer lena = Creator.createCustomer("lena", "llitouka", "zipcode", new Checking(103, 1500), new Savings(1003, 2500), new Investment(10003, 6000));
        Database.addMultipleCustomers(xiong, mike, hazel, lena);

        while(test.engineOn) {
            test.runEngine(screen);
        }

    }

    public void runEngine(Workflow screen) {
        customerLogin(screen);
    }


    public void customerLogin(Workflow screen) {
        screen.initialWelcomeSP();
        boolean test = true;
        Integer input = screen.getInput();
        while (test)
            switch (input) {
                case 1:
                    createCustomer();
                    test = false;
                    break;
                case 2:
                    Customer currentUser = validateCredentials(screen);
                    if (currentUser == null) {
                        System.out.println("Sorry cannot log you in at this time");
                        test = false;
                        break;
                    }
                    returningCustomer(screen, currentUser);
                    test = false;
                    break;
                case 0:
                    System.out.println("Thank you for using this ATM, have a nice day!");
                    test = false;
                    break;
                default:
                    input = screen.getInput();
                    System.out.println("Please choose use 1 for new customer or 2 for returning customer, 0 to exit.");
                    break;
            }
    }

    public Customer validateCredentials(Workflow screen) {
        String newUsername = screen.getUserSP();
        int counter = 0;
        int tries = 3;

        while(Database.getCustomerByUsername(newUsername) == null) {
            System.out.println("Account not on file");
            newUsername = screen.getUserSP();
        }

        Customer currentUser = Database.getCustomerByUsername(newUsername);

        while(counter < 3) {
            String userPass = screen.getPassSP();
            if (currentUser.getPassword().equals(userPass)) {
                return currentUser;
            } else
                counter++;
                tries--;
                System.out.println(String.format("Invalid password: Tries left - %s", tries));
        }

        return null;
    }

    public void createCustomer() {
        Workflow screen = new Workflow();
        Customer newCustomer = Creator.createCustomer(null, null, null, null);
        String newCustomerName = screen.getCustomerNameSP();
        newCustomer.setCustomerName(newCustomerName);
        screen.newUserSP();
        String newUsername = screen.getUserSP();
        boolean user = true;
        while (user)
            if (Database.getCustomerByUsername(newUsername) != null) {
                screen.usernameTakenSP();
                newUsername = screen.getUserSP();
            } else {
                newCustomer.setUserName(newUsername);
                user = false;
            }

        boolean pass = true;
        while (pass) {
            String newPassword = screen.getPassSP();
            String newPasswordConfirm = screen.getPassSP();
            if (newPasswordConfirm.equals(newPassword)) {
                newCustomer.setPassword(newPassword);
                pass = false;
            } else {
                screen.passwordMismatchSP();
            }
        }

        System.out.println("Please type Checking, Savings, Investments");
        openingAccount(screen, newCustomer);
        Database.addCustomer(newCustomer);
    }


    public void returningCustomer(Workflow screen, Customer customer){
        boolean currentlyUsing = true;

        while(currentlyUsing) {
            screen.mainMenuSP(customer);
            Integer input = screen.getInput();
            switch (input) {
                case 1:
                    check(screen, customer);
                    break;
                case 2:
                    transfer(screen, customer);
                    break;
                case 3:
                    withdrawal(screen, customer);
                    break;
                case 4:
                    deposit(screen, customer);
                    break;
                case 5:
                    openingAccount(screen, customer);
                    break;
                case 6:
                    closingAccount(screen, customer);
                    break;
                case 7:
                    history(screen);
                    break;
                case 8:
                    screen.logOutSP();
                    currentlyUsing = false;
            }
        }
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
    public void closingAccount(Workflow screen, Customer customer) {
        screen.closePrompt();
        Integer oldAccount=screen.enterAccount();
        Boolean validAccount=true;
        while(customer.getAccount(oldAccount)==null){
            System.out.println("Account not on file");
            oldAccount=screen.enterAccount();
        }
        while(validAccount){
            if(customer.getAccount(oldAccount).getBalance()==0)
            {
                customer.closeAccount(oldAccount);
                break;
            }
            else {
                System.out.println("Must be empty");
                System.out.println("Remaining balance: $"+customer.getAccount(oldAccount).getBalance());
                break;
            }

        }
        System.out.println("User accounts: "+"\n"+customer.getAccountNumber());
        screen.completeResultsNoHistorySP();
    }

    public void openingAccount(Workflow screen,Customer customer) {
        String uniqAccount = screen.openPrompt();
        boolean validType = true;
        while (validType) {
            if ("checking".equals(uniqAccount)) {
                double firstCheckingDeposit = screen.amountPromptSP();
                Checking uniqChecking = Creator.createChecking(firstCheckingDeposit);
                customer.addAccount(uniqChecking);
                System.out.println(uniqChecking.getAccountNumber());
                System.out.println(uniqChecking.getBalance());
                System.out.println("User accounts: "+"\n"+customer.getAccountNumber());
                break;
            } else if ("savings".equals(uniqAccount)) {
                double firstSavingDeposit = screen.amountPromptSP();
                Checking uniqSaving = Creator.createChecking(firstSavingDeposit);
                customer.addAccount(uniqSaving);
                System.out.println(uniqSaving.getAccountNumber());
                System.out.println(uniqSaving.getBalance());
                System.out.println("User accounts: "+"\n"+customer.getAccountNumber());
                break;
            } else if ("investment".equals(uniqAccount)) {
                double firstInvestmentDeposit = screen.amountPromptSP();
                Checking uniqInvestment = Creator.createChecking(firstInvestmentDeposit);
                customer.addAccount(uniqInvestment);
                System.out.println(uniqInvestment.getAccountNumber());
                System.out.println(uniqInvestment.getBalance());
                System.out.println("User accounts: "+"\n"+customer.getAccountNumber());
                break;
            } else
            {
                System.out.println("Not a valid entry. Please type in checking, savings, investment");
                uniqAccount = screen.openPrompt();
            }

        }

    }

    public void check(Workflow screen, Customer customer){
        screen.checkPromptSP();
        while(true) {
            try {
                Integer acctNumber = screen.enterAccount();
                screen.checkResultSP(customer.getAccount(acctNumber));
                break;
            } catch (Exception e) {
                screen.errorSP();
            }
        }
    }

    public void history(Workflow screen){
        screen.printHistory();
    }
}

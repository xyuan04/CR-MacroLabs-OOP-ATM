public class HazelMain {

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

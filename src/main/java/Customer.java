import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
    private String customerName;
    private String userName;
    private String password;
    private List<Account> accounts = new ArrayList<Account>();


    public Customer(String customerName, String userName, String password, Account[] accounts){
        this.customerName = customerName;
        this.userName = userName;
        this.password = password;
        this.accounts = Arrays.asList(accounts);
    }

    public String getCustomerName(){ return this.customerName;}

    public void setCustomerName(String customerName){ this.customerName = customerName;}

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getAccountNumber() {
        String accountNumbers = "";
        for(int i = 0; i < accounts.size(); i++) {
            accountNumbers += String.format("%s ", accounts.get(i).getAccountNumber());
        }
        return accountNumbers;
    }

    public void openCheckingAccount(int accountNumber, double initialDeposit) {
        Account newAccount = new Checking(accountNumber, initialDeposit);
        accounts.add(newAccount);
    }

    public void openSavingsAccount(int accountNumber, double initialDeposit) {
        Account newAccount = new Savings(accountNumber, initialDeposit);
        accounts.add(newAccount);
    }

    public void openInvestmentAccount(int accountNumber, double initialDeposit) {
        Account newAccount = new Investment(accountNumber, initialDeposit);
        accounts.add(newAccount);
    }

    public void closeAccount(Integer accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                if (accounts.get(i).getBalance() == 0) {
                    accounts.remove(i);
                }
            }
        }
    }
}

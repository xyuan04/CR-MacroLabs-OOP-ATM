import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String userName;
    private String passWord;
    private ArrayList<Customer> accountNumbers = new ArrayList<Customer>();
    private Integer accountNum;


    public Customer(String userName, String passWord, Integer accountNum){
        this.userName = userName;
        this.passWord = passWord;
        this.accountNum = accountNum;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassWord(){
        return this.passWord;
    }

    public void setPassWord(String passWord){
        this.userName = passWord;
    }

    public ArrayList<Customer> getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(String userName, String passWord, Integer accountNum) {
        Customer accountNumbers = new Customer(userName, passWord, accountNum);
        this.accountNumbers.add(accountNumbers);
    }

}
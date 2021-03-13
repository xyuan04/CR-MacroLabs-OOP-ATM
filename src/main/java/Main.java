/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        Workflow w = new Workflow();
        Customer person = new Customer("Hazel", "12345", 67890);
        w.mainMenuSP(person);
    }
}

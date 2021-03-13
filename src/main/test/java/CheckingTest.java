import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckingTest {

    @Test
    public void testConstructor() {
        // : Given
        Integer accountChecking = 14104244;
        double initialDeposit = 1000.00;

        // : When
        Checking checking101 = new Checking(accountChecking, initialDeposit);
        Integer actualAccountNumber = checking101.getAccountNumber();
        double actualBalance = checking101.getBalance();

        // : Then
        Assert.assertEquals(accountChecking, actualAccountNumber);
        Assert.assertEquals(initialDeposit, actualBalance, 0.00001);
    }

    @Test
    public void testTransferToSavings() {
        // : Given
        Integer accountChecking = 14104244;
        Integer accountSavings = 160811456;
        double initialDeposit = 1000.00;
        Checking checking101 = new Checking(accountChecking, initialDeposit);
        Savings savings101 = new Savings(accountSavings, initialDeposit);

        // : When
        double expectedCheckingBalance = 800;
        double expectedSavingsBalance = 1200;
        double actualCheckingBalance = checking101.transferToSavings(savings101, 200);
        double actualSavingsBalance = savings101.getBalance();

        System.out.println(checking101.getBalance());
        System.out.println(savings101.getBalance());

        // : Then
        Assert.assertEquals(expectedCheckingBalance, actualCheckingBalance, 0.000001);
        Assert.assertEquals(expectedSavingsBalance, actualSavingsBalance, 0.000001);


    }

    @Test
    public void transferToInvestment() {
    }
}
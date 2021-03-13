import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

        @Test
        public void customerConstuctor() {
            // : Given
            String customerName = "Xiong Yuan";
            String userName = "xyuan";
            String password = "zipcode0";
            Account checkingAccount = new Checking(24231, 23142);
            Account[] accounts = new Account[]{checkingAccount};

            // : When
            Customer xiong = new Customer(customerName, userName, password, accounts);
            String actualName = xiong.getCustomerName();
            String actualUserName = xiong.getUserName();
            String actualPassword = xiong.getPassword();
            String account = "24231 ";
            String actualAccount = xiong.getAccountNumber();

            // : Then
            Assert.assertEquals(customerName, actualName);
            Assert.assertEquals(userName, actualUserName);
            Assert.assertEquals(password, actualPassword);
            Assert.assertEquals(account, actualAccount);

        }


        @Test
        public void getCustomerName() {
            // : Given
            String customerName = "Lena Litouka";
            String userName = "llitouka";
            String password = "zipcode0";
            Account checkingAccount = new Checking(23142, 23214);
            Account[] accounts = new Account[]{checkingAccount};
            // : When
            Customer lena = new Customer(customerName, userName, password, accounts);
            String actualName = lena.getCustomerName();

            // : Then
            Assert.assertEquals(customerName, actualName);

        }
        @Test
        public void setCustomerName() {
            // : Given
            String customerName = "Liam Becker";
            String userName = "hbecker";
            String password = "zipcode0";
            Account checkingAccount = new Checking(22456, 25631);
            Account[] accounts = new Account[]{checkingAccount};
            // : When
            Customer hazel = new Customer(customerName, userName, password, accounts);
            hazel.setCustomerName("Hazel Becker");
            String expected = "Hazel Becker";
            String actualName = hazel.getCustomerName();
            // : Then
            Assert.assertEquals(expected, actualName);
        }

        @Test
        public void getUserName() {
            // : Given
            String customerName = "Mike Ninh";
            String userName = "DynoMike";
            String password = "zipcode0";
            Account checkingAccount = new Checking(26226, 12956);
            Account[] accounts = new Account[]{checkingAccount};
            // : When
            Customer mike = new Customer(customerName, userName, password, accounts);
            String actualName = mike.getUserName();
            // : Then
            Assert.assertEquals(userName, actualName);
        }

        @Test
        public void setUserName() {
            String customerName = "Ask Ketchum";
            String userName = "WannaPokemonMaster";
            String password = "BeTheVeryBest";
            Account checkingAccount = new Checking(34113, 1000);
            Account[] accounts = new Account[]{checkingAccount};
            // : When
            Customer ketchumAll = new Customer(customerName, userName, password, accounts);
            ketchumAll.setUserName("PokemonMaster");
            String expected = "PokemonMaster";
            String actualName = ketchumAll.getUserName();
            // : Then
            Assert.assertEquals(expected, actualName);
        }

        @Test
        public void getPassWord() {
            String customerName = "Tony Stark";
            String userName = "IronMan";
            String password = "zipcode0";
            Account checkingAccount = new Checking(12402, 923132956);
            Account[] accounts = new Account[]{checkingAccount};
            // : When
            Customer stark = new Customer(customerName, userName, password, accounts);
            String actualpassword = stark.getPassword();
            // : Then
            Assert.assertEquals(password, actualpassword);
        }

        @Test
        public void setPassWord() {
            String customerName = "";
            String userName = "";
            String password = "";
            Account checkingAccount = new Checking(22456, 25631);
            Account[] accounts = new Account[]{checkingAccount};
            // : When
            Customer test = new Customer(customerName, userName, password, accounts);
            test.setPassword("spotholder");
            String expectedPW = "spotholder";
            String actualPW = test.getPassword();
            // : Then
            Assert.assertEquals(expectedPW, actualPW);
        }

        @Test
        public void getAccountNumber() {
            // : Given
            String customerName = "Bruce Wayne";
            String userName = "NotBatman";
            String password = "zipcode0";
            Account checkingAccount = new Checking(32563, 915252956);
            Account[] accounts = new Account[]{checkingAccount};
            // : When
            String account = "32563 ";
            Customer wayne = new Customer(customerName, userName, password, accounts);
            String actualAccount = wayne.getAccountNumber();
            // : Then
            Assert.assertEquals(account, actualAccount);
        }

    }
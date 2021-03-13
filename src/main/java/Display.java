public class Display {

    String currentDisplay;
    String menu;
    String transactionHistory;

    public Display(){
        this.currentDisplay = "";
        this.menu = "";
        this.transactionHistory = "";
    }

    public void printCurrentDisplay() {
        System.out.println(currentDisplay);
    }

    public void setCurrentDisplay(String currentDisplay) {
        this.currentDisplay = currentDisplay;
    }

    public void printMenu() {
        System.out.println(menu);
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void printTransactionHistory() {
        System.out.println(transactionHistory);
    }

    public void setTransactionHistory(String transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}

public class Display {

    String currentDisplay;
    String menu;
    String transactionHistory;

    public Display(){
        this.currentDisplay = "";
        this.menu = "";
        this.transactionHistory = "";
    }

    public String getCurrentDisplay() {
        return currentDisplay;
    }

    public void setCurrentDisplay(String currentDisplay) {
        this.currentDisplay = currentDisplay;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(String transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}

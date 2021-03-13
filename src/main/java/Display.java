public class Display {

    String currentDisplay;
    //String menu;
    String transactionHistory;

    public Display(){
        this.currentDisplay = "";
        //this.menu = "";
        this.transactionHistory = "";
    }

    /* *****Getters and setters***** */

    public void printCurrentDisplay() {
        System.out.println(currentDisplay);
    }

    public void setCurrentDisplay(String currentDisplay) {
        this.currentDisplay = currentDisplay;
    }

    //set AND print in one
    public void currentDisplaySP(String currentDisplay){
        this.setCurrentDisplay(currentDisplay);
        this.printCurrentDisplay();
    }



    /*public void printMenu() {
        System.out.println(menu);
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    //set AND print in one
    public void menuSP(String menu){
        this.setMenu(menu);
        this.printMenu();
    }*/



    public void printTransactionHistory() {
        System.out.println(transactionHistory);
    }

    public void setTransactionHistory(String transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void addToTransactionHistory(String snippet){
        this.transactionHistory = this.transactionHistory + snippet;
    }


}










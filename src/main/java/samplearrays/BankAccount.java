package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    int max_transactions = 1000;        // Setting max transactions to be 1000
    double[] transactions = new double[max_transactions]; // Creating an array of doubles of size (max_transactions)
    int transaction_index = 0;          // The transaction_index allows to trace the current transaction and adding it after the last used place

    public BankAccount(String name, int startingBalance){
        // Initializing the attributes
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        // Checking the validity of amount which must be positive
        if (amount <= 0) {
            System.out.println("Unsuccessful deposit");
            return;
        }

        // If the amount is valid add the amount to the balance
        currentBalance += amount;
        // if there is place in the transactions register, register this transaction
        if(transaction_index < max_transactions - 1) {
            transactions[transaction_index] = amount;
            transaction_index++;
        }
        // Print deposit message
        System.out.println(name + " deposit " + amount + ", new balance: " + currentBalance);
    }

    public void withdraw(double amount){
        // Checking the validity of amount which must be positive and less than or equal the currenBalance
        if (amount > currentBalance || amount <= 0) {
            System.out.println("Unsuccessful withdrawal");
            return;
        }

        // If the amount is valid withdraw the amount from the balance
        currentBalance -= amount;
        // if there is place in the transactions register, register this transaction
        if(transaction_index < max_transactions - 1) {
            transactions[transaction_index] = (-1) * amount;
            transaction_index++;
        }
        // Print withdraw message
        System.out.println(name + " withdraw " + amount + ", new balance: " + currentBalance);
    }

    public void displayTransactions(){
        // Iterating through the transactions register and print each transaction with the corresponding sign
        for (int i = 0; i < transaction_index; i++) {
            if(transactions[i] > 0) {
                System.out.println("+" + transactions[i]);
            } else {
                System.out.println(transactions[i]);
            }
        }
    }

    public void displayBalance(){
        // printing the current balance
        System.out.println("Current balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}

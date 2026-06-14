import java.util.Scanner;          

class ATM {

    private int balance;
    private int pin;
    private boolean loggedIn;

    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
        this.loggedIn = false;
    }

    // Login
    public boolean login(int enteredPin) {
        if (enteredPin == pin) {
            loggedIn = true;
            System.out.println("Login Successful.");
            return true;
        } else {
            System.out.println("Invalid PIN.");
            return false;
        }
    }

    // Logout
    public void logout() {
        loggedIn = false;
        System.out.println("Session Ended. Thank you for using ATM.");
    }

    // Balance Check
    public void checkBalance() {
        if (loggedIn) {
            System.out.println("Current Balance: Rs. " + balance);
        } else {
            System.out.println("Please login first.");
        }
    }

    // Deposit
    public void deposit(int amount) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }

        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw
    public void withdraw(int amount) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        }
    }

    // Menu
    public void displayMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Logout");
        System.out.print("Enter Choice: ");
    }

    public void transfer(int amount, ATM receiver) {

        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            receiver.balance += amount;

            System.out.println("Rs. " + amount + " transferred successfully.");
            System.out.println("Remaining Balance: Rs. " + balance);
        }
    }
}

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM(10000, 1234);
        ATM receiverAccount = new ATM(5000, 5678);

        System.out.println("===== ATM SYSTEM =====");
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.login(enteredPin)) {
            System.out.println("Access Denied.");
            sc.close();
            return;
        }

        int choice;

        do {
            atm.displayMenu();
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    int depositAmount = sc.nextInt();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ");
                    int withdrawAmount = sc.nextInt();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter Transfer Amount: ");
                    int transferAmount = sc.nextInt();

                    atm.transfer(transferAmount, receiverAccount);
                    break;

                case 5:
                    atm.logout();
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

import java.util.*;

class BankAccount {

    private long accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = new ArrayList<>();

        transactions.add("Account Created with Initial Deposit ₹" + balance);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount!");
            return;
        }

        balance += amount;
        transactions.add("Deposited ₹" + amount);

        System.out.println("Deposit Successful!");
        System.out.println("Updated Balance: ₹" + balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
            return;
        }

        balance -= amount;
        transactions.add("Withdrawn ₹" + amount);

        System.out.println("Withdrawal Successful!");
        System.out.println("Remaining Balance: ₹" + balance);
    }

    public void showTransactionHistory() {

        System.out.println("\nTransaction History:");

        if (transactions.isEmpty()) {
            System.out.println("No Transactions Found!");
            return;
        }

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Override
    public String toString() {
        return "\nAccount Number : " + accountNumber +
               "\nAccount Holder : " + accountHolder +
               "\nBalance : ₹" + balance;
    }
}

public class BankManagementSystem {

    private static HashMap<Long, BankAccount> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    // Create Account
    public static void createAccount() {

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        sc.nextLine();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account Already Exists!");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Initial Deposit Cannot Be Negative!");
            return;
        }

        BankAccount account = new BankAccount(accNo, name, balance);

        accounts.put(accNo, account);

        System.out.println("Account Created Successfully!");
    }

    // Deposit
    public static void depositMoney() {

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        BankAccount account = accounts.get(accNo);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.print("Enter Amount To Deposit: ");
        double amount = sc.nextDouble();

        account.deposit(amount);
    }

    // Withdraw
    public static void withdrawMoney() {

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        BankAccount account = accounts.get(accNo);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.print("Enter Amount To Withdraw: ");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }

    // Check Balance
    public static void checkBalance() {

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        BankAccount account = accounts.get(accNo);

        if (account == null) {
            System.out.println("Account Not Found!");
        } else {
            System.out.println(account);
        }
    }

    // Search Account
    public static void searchAccount() {

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        BankAccount account = accounts.get(accNo);

        if (account == null) {
            System.out.println("Account Not Found!");
        } else {
            System.out.println(account);
        }
    }

    // Transaction History
    public static void viewTransactionHistory() {

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        BankAccount account = accounts.get(accNo);

        if (account == null) {
            System.out.println("Account Not Found!");
        } else {
            account.showTransactionHistory();
        }
    }

    // Display All Accounts
    public static void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available!");
            return;
        }

        System.out.println("\n===== ALL ACCOUNTS =====");

        for (BankAccount account : accounts.values()) {
            System.out.println(account);
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {

        int choice = 0;

        do {

            try {

                System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Check Balance");
                System.out.println("5. Search Account");
                System.out.println("6. View Transaction History");
                System.out.println("7. View All Accounts");
                System.out.println("8. Exit");

                System.out.print("Enter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        createAccount();
                        break;

                    case 2:
                        depositMoney();
                        break;

                    case 3:
                        withdrawMoney();
                        break;

                    case 4:
                        checkBalance();
                        break;

                    case 5:
                        searchAccount();
                        break;

                    case 6:
                        viewTransactionHistory();
                        break;

                    case 7:
                        displayAllAccounts();
                        break;

                    case 8:
                        System.out.println("Thank You For Using Our Bank System!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid Input! Please Enter Numbers Only.");
                sc.nextLine();
            }

        } while (choice != 8);

        sc.close();
    }
}

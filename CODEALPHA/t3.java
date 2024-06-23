import java.util.Scanner;

public class t3 {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", "12345");
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        do {
            System.out.println("Welcome, " + account.getCustomerName());
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit of $" + depositAmount + " successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal of $" + withdrawAmount + " successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our banking application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    break;
            }
            
            System.out.println(); // Empty line for better readability
            
        } while (choice != 4);
        
        scanner.close();
    }

}

class BankAccount {
    private String customerName;
    private double balance;

    public BankAccount(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.balance = 0.0;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

    


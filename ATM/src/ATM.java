import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }
    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }
    public void executeOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ₹");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 3:
                System.out.print("Enter deposit amount: ₹");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    private void checkBalance() {
        System.out.println("Current Balance: ₹" + userAccount.getBalance());
    }
    private void withdraw(double amount) {
        userAccount.withdraw(amount);
    }
    private void deposit(double amount) {
        userAccount.deposit(amount);
    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.executeOption(choice);
        }
    }
}

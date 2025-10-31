# ATM1_machine
ATM1_machine
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ATM {
    private Map<String, Account> accounts;
    private Scanner scanner;

    public ATM() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);

        // Initialize accounts
        accounts.put("12345", new Account("12345", "John Doe", 1000.0));
        accounts.put("67890", new Account("67890", "Jane Doe", 500.0));
    }

    public void run() {
        while (true) {
            System.out.println("Enter your account number:");
            String accountNumber = scanner.nextLine();

            if (accounts.containsKey(accountNumber)) {
                Account account = accounts.get(accountNumber);
                System.out.println("Enter your PIN (default PIN is 1234):");
                String pin = scanner.nextLine();

                if (pin.equals("1234")) {
                    accountMenu(account);
                } else {
                    System.out.println("Invalid PIN. Please try again.");
                }
            } else {
                System.out.println("Account not found. Please try again.");
            }
        }
    }

    private void accountMenu(Account account) {
        while (true) {
            System.out.println("Account Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume

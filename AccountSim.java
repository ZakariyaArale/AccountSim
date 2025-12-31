import java.util.Scanner;

public class AccountSim {
    private Scanner scanner = new Scanner(System.in);
    private BankAccountRepository repository = new BankAccountRepository();
    private TransactionService transactionService = new TransactionService();

    public static void main(String[] args) {
        AccountSim app = new AccountSim();
        app.start();
    }

    private void start() {
        while (true) {
            printStar();
            System.out.println("Welcome to Arale Bank powered by Zakariya INC");
            printStar();

            BankAccount account = authenticateOrCreateAccount();
            if (account == null) continue;

            System.out.println(account);
            printStar();

            transactionService.handleTransactions(account);

            System.out.println("Thank you and have a wonderful day :)!");
            printStar();
        }
    }

    private BankAccount authenticateOrCreateAccount() {
        System.out.println("Enter your bank account number: ");
        long accountNumber = scanner.nextLong();
        printStar();

        System.out.println("Enter your 4-digit pin number: ");
        int pinNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        printStar();

        BankAccount existingAccount = repository.findByAccountNumber(accountNumber);
        if (existingAccount != null) {
            if (existingAccount.getPin() != pinNumber) {
                System.out.println("Invalid pin number, please try again.");
                return null;
            }
            return existingAccount;
        }

        BankAccount newAccount = new BankAccount(accountNumber, pinNumber);
        repository.save(newAccount);
        return newAccount;
    }

    private void printStar() {
        System.out.println("***********************************************************************************************************************");
    }
}

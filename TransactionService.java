import java.util.Scanner;

public class TransactionService {
    private Scanner scanner = new Scanner(System.in);

    public void handleTransactions(BankAccount account) {
        while (true) {
            System.out.println("Would you like to deposit, withdraw, or change the interest rate? Type \"deposit\", \"withdraw\", or \"interest\":");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "deposit":
                    System.out.println("How much do you want to deposit?");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case "withdraw":
                    System.out.println("How much do you want to withdraw?");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case "interest":
                    System.out.println("Enter new interest rate (percentage):");
                    double interestRate = scanner.nextDouble();
                    account.interest(interestRate);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    continue;
            }

            scanner.nextLine(); 
            System.out.println(account);
            System.out.println("Are you satisfied? Type \"Yes\" to finish or \"No\" to continue:");
            String satisfied = scanner.nextLine();
            if (satisfied.equalsIgnoreCase("Yes")) break;
        }
    }
}

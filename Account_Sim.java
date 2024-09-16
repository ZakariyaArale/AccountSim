// Zakariya Arale
// 01/11/2023
/* We are require to make the code for a online banking program
   that simulates the typical transactions in a bank account
   NOTE: this program must be executed with the file Bank_Account.java
*/
import java.util.*; 
public class Account_Sim extends ConsoleProgram
{
    public void run()
    {
       // 1. Welcome the user
       // 2. Get the user's bank account number and enter their pin number
       // 3. If it is an existing customer, verify the account, if false repeat step, if true or if it is a new account continue
       // 4. Print out there current bank account number, pin, balence and interest rate
       // 5. Save data of the customer if it is a new user
       // 6. Ask the user if they want to deposit, withdraw, or change the interest rate
       // 7. Print out their balence
       // 8. Ask if the user is satisfy. If no repeat step 4, else..
       // 9. Bid farwell to the user
       // 10. Reapeat step 1
        
       int i = 0; // This is where the variable i is initalized to the vaule 0, this is to ensure we can make a true statemnt for the while loop
       Bank_Account[] storage = new Bank_Account[100];// This is where the bank accounts are stored
       int counter = 0; // This is where the counter variable is created to store
       while(i == 0)  // This is where the infine loop is created, we want an infinite loop since instant teller always repeat for the next customer
       {
            // 1. Welcome the user
            System.out.println("Welcome to Arale Bank powered by Zakariya INC"); // This is the welcome message to the customer
            printStar(); // Line Breaker
            // 2. Get the user's bank account number and enter their pin number
            Scanner sc = new Scanner(System.in); // This is the scanner object that takes in the required data
            System.out.println("Enter your bank account number: "); // This is where the user inputs the bank account
            long accountNumber = sc.nextLong(); // This is where the value is stored
            printStar(); // Line Breaker
            System.out.println("Enter your 4-digit pin number: "); // This is where the user inputs the 4-digit pin
            int pinNumber = sc.nextInt(); // This is where the value is stored
            printStar(); // Line Breaker
            // 3. If it is an existing customer, verify the account, if false repeat step, if true or if it is a new account continue
            // The following piece of code will verify the pin number for an existing bank account
            if(counter != 0)
            {
                Bank_Account b1 = storage [counter - 1];
                if(b1.getPin() != pinNumber) // If the pin number is not correct, then the code will pause
                {
                    System.out.print("Invalid pin number please try again. Press stop and run again");
                    try 
                    {
                        Thread.sleep(50000);
                    } 
                    catch (InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                }
            }
            // The code will contiue to run if it is a new account or if everything is verified
            // 4. Print out there current bank account number, pin, balence and interest rate
            Bank_Account b1 = new Bank_Account(accountNumber, pinNumber); // This is where the data of the bank account is stored
            if(counter != 0)
            {
                b1 = storage [counter - 1]; // An existing bank account will be used if the counter is greater than zero
            }
            else
            {
            // 5. Save data of the customer if it is a new user
            storage[counter] = b1; // A new bank account will be stored 
            counter++;
            }
            System.out.println(b1); // This is where the current statemnt of the account
            printStar(); // Line Breaker
            // 6. Ask the user if they want to deposit, withdraw or change the interest rate
            System.out.println("Would you like to deposit or withdraw or change the interest rate. Type \"deposit\" to deposit, type \"withdraw\" to withdraw, type \"interest\" to change the interest rate.");
            sc.nextLine();
            String deposit_Withdraw = sc.nextLine();
            printStar();// Line Breaker
             if(deposit_Withdraw.equalsIgnoreCase("deposit") || deposit_Withdraw.equals("withdraw") || deposit_Withdraw.equals("interest")) // This will run depending on what the user inputs
             {
              int y = 1; // This is where the variable y is initalized to the vaule 0, this is to ensure we can make a true statemnt for the while loop
              while(y == 1)
              {
                 if(deposit_Withdraw.equalsIgnoreCase("deposit"))
                 {
                     System.out.println("How much do you want to deposit?"); 
                     double despo = sc.nextDouble();
                     b1.deposit(despo);
                     printStar();// Line Breaker
                      // 7. Print out their balence
                     System.out.println(b1);
                 }
                 else if(deposit_Withdraw.equalsIgnoreCase("withdraw"))
                 {
                    System.out.println("How much do you want to withdraw?"); 
                     int with = sc.nextInt();
                     b1.withdraw(with);
                      // 7. Print out their balence
                     System.out.println(b1);
                 }
                 else if(deposit_Withdraw.equalsIgnoreCase("interest"))
                 {
                    System.out.println("What do you want the interest rate to be? Enter in percentage."); 
                    double itr = sc.nextDouble();
                    b1.interest(itr);
                      // 7. Print out their balence
                    System.out.println(b1);  
                 }
                 // 8. Ask if the user is satisfy. If no repeat step 4, else..
                 printStar(); // Line Breaker
                 System.out.println("Are you satisfy or would you like to continue to deposit, withdraw and/or change the interest rate. Type \"Yes\" if you are satisfy. Type \"No\" if not.");
                 sc.nextLine();
                 String satisfy = sc.nextLine();
                 printStar();// Line Breaker
                 if(satisfy.equalsIgnoreCase("Yes"))
                 {
                     break; // Move to step 9 if successful
                 }
                System.out.println("Would you like to deposit or withdraw or change the interest rate. Type \"deposit\" to deposit, type \"withdraw\" to withdraw, type \"interest\" to change the interest rate.");
                 deposit_Withdraw = sc.nextLine();
                 printStar();// Line Breaker
              }
             } 
             // 9. Bid farwell to the user
             System.out.println("Thank you and have a wonderful day :)!");
             printStar(); // Line Breaker
             // 10. Reapeat step 1
       }
    }
    // This is the method for the line breaker, a simple println statemt with asterisk symbol
    private void printStar()
    {
        System.out.println("***********************************************************************************************************************");
    
    }
}

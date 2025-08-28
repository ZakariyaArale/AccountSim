public class Bank_Account
{
    // A bank account should have a bank acoount number, pin number, balence and interest rate
    private long acct_num; // This instance variable is for the account number
    private int pin; // This instance variableis for the pin 
    private double balance = 0.00; // This instance variable is for the balaence 
    private double interest = 0; // This instance variable is for the interest
    // Make the contrsutor for the bank account class
    /**
     * @param acct_num is the account number
     * @param pin is the 4-digit pin number
     * 
     */
    public Bank_Account(long acct_num, int pin)
    {
        this.acct_num = acct_num; // This is where the instance variable for the account number is initialized to the object value created
        this.pin = pin; // This is where the instance variable for the pin number is initialized to the object value created
    }
    // Make the deposit method to deposit money in the bank account
    /**
     * @param x is the amount deposited in the bank account balence
     * 
     */
    public void deposit(double x)
    {
        balance += x; // This is where the balence increases based on the value x
    }
    // Make the withdraw method to withdraw money in the bank account
    /**
     * @param x is the amount withdraw in the bank account balence
     * 
     */
    public void withdraw(double x)
    {
        balance -= x; // This is where the balence decreases based on the value x
    }
    // Make the interest method to increase the balence based on the interest rate in the bank account
    /**
     * @param x is interest rate in the bank account
     * 
     */
    public void interest(double x)
    {
        interest = (double)x / (double)100;
        balance = balance *(1 + (interest)); // This is where the interest rate will change the balence based on the value x
    }
    // We need in input a get method for the pin to verify a pin number
    /**
     * @return the pin number of a bank account
     * 
     */
    public int getPin()
    {
        return pin;
    }
    // Add a toString message to update the user of there bank account number inputted, there current pin number, balence and interest rate
    /**
     * @retrun the user's current bank account number, pin number, interest rate and balence
     * 
     */
    public String toString()
    {
        return "For the bank account "  + acct_num  + ", with the 4 digit pin number " + pin + ", the current balence is $" + balance + " an the interest rate is " + interest*100 + "%.";
    }
}

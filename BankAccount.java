public class BankAccount
{
    private long acct_num;
    private int pin;
    private double balance;
    private double interest;

    public BankAccount(long acct_num, int pin)
    {
        this.acct_num = acct_num;
        this.pin = pin;
        balance = 0.00;
        interest = 0;
    }

    public void deposit(double x)
    {
        balance += x;
    }

    public void withdraw(double x)
    {
        balance -= x;
    }

    public void interest(double x)
    {
        interest = (double)x / 100;
        balance = balance * (1 + interest);
    }

    public int getPin()
    {
        return pin;
    }
    
    public long getAccountNumber()
    {
        return acct_num;
    }


    public String toString()
    {
        return "For the bank account "  + acct_num  + ", with the 4 digit pin number " + pin + ", the current balance is $" + balance + " and the interest rate is " + interest*100 + "%.";
    }
}

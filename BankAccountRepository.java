import java.util.ArrayList;
import java.util.List;

public class BankAccountRepository {
    private List<BankAccount> accounts = new ArrayList<>();

    public void save(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findByAccountNumber(long accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // account not found
    }
}


public class Account {
    private static int account_count = 0;
    private double balance;

    private int id;

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public Account() {
        balance = 0;
        id = account_count++;
    }

    public Account(double startingBalance) {
        this.balance = startingBalance;
        id = account_count++;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount >= 0)
            balance += amount;
    }
}

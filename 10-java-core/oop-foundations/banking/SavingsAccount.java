package oop_foundations.banking;

public class SavingsAccount extends Account {
    private static final double RATE = 0.04;
    private static final double MIN_BAL = 100;

    public SavingsAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    public void withdraw(double amount) {
        if (balance - amount < MIN_BAL)
            throw new IllegalArgumentException("Minimum balance required");
        super.withdraw(amount);
    }

    public double calculateInterest() {
        return balance * RATE;
    }
}

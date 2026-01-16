package oop_foundations.banking;

public abstract class Account {
    protected int accountNumber;
    protected String holderName;
    protected double balance;

    private static int counter = 2000;

    public Account(String holderName, double balance) {
        this.accountNumber = ++counter;
        this.holderName = holderName;
        this.balance = balance;
    }

    public abstract double calculateInterest();

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }
}

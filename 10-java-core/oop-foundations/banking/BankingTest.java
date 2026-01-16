package oop_foundations.banking;

public class BankingTest {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");

        Account s = new SavingsAccount("Alice", 1000);
        Account c = new CheckingAccount("Bob", 500);
        Account f = new FixedDepositAccount("Charlie", 10000);

        bank.addAccount(s);
        bank.addAccount(c);
        bank.addAccount(f);

        s.deposit(500);
        c.withdraw(800);

        System.out.println("Total deposits: $" + bank.getTotalDeposits());

        for (Account acc : bank.getAllAccounts()) {
            System.out.println(acc.getHolderName() +
                    " interest: $" + acc.calculateInterest());
        }
    }
}

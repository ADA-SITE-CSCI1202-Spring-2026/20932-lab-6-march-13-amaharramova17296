public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(101, "Ayan M", 10000);

        account1.deposit(1500);

        try {
            account1.withdraw(18005); 
        } catch (InvalidAmountException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            account1.withdraw(2000);
        } catch (InvalidAmountException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Final Balance: " + account1.getBalance());
    }
}



class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance ) {
       this.accountNumber = accountNumber;
       this.accountHolderName = accountHolderName;
       this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount>balance) {
        throw new InvalidAmountException("Withdrawal amount cannot exceed balance!");
        } else if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount should be positive!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + balance);
        }
    }

}

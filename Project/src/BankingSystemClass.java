class BankingSystem {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankingSystem(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0; 
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful! Remaining balance: " + balance);
            return true;
        }
        System.out.println("Insufficient balance or invalid amount.");
        return false;
    }
}



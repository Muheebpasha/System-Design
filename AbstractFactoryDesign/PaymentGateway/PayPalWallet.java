public class PayPalWallet implements Wallet {
    private double balance = 1000.0;

    @Override
    public void addFunds(double amount) {
        balance += amount;
        System.out.println("Added $"+amount+" to PayPal Wallet");
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void processPayment(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Processing PayPal Wallet Payment of $ "+amount);
       } else {
            System.out.println("You have Insufficient Balance in PayPal Wallet");
       }
        
    }
    
}
public class StripeWallet implements Wallet {
    private double balance = 500.00;
    @Override
    public void addFunds(double amount) {
        balance += amount;
        System.out.println("Added $"+amount+" to Stripe Wallet.");
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void processPayment(double amount) {
        if(balance>=amount) {
            balance -= amount;
            System.out.println("Processing Stripe Wallet Payment of $"+amount);
        } else {
            System.out.println("Insufficent Stripe Wallet Balance.");
        }
    }

}
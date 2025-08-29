public interface Wallet {
    void processPayment(double amount);
    double checkBalance();
    void addFunds(double amount);
}
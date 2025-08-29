public interface Card {
    void processPayment(double amount);
    boolean validateCardDetails();
    String getCardType();
}
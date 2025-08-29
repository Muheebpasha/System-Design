// Step 4: Client Code (E-commerce App)
public class ShoppingCart {
    private PaymentProcessor paymentProcessor;

    public ShoppingCart(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    
    public void checkout(int amount) {
        paymentProcessor.pay(amount);
    }
}

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void pay(int amount) {
        stripe.processPayment(amount*100); // Stripe expects cents
    }
    
}

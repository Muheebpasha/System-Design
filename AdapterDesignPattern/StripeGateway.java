// Third-party Stripe library
public class StripeGateway {
    public void processPayment(int cents) {
        System.out.println("Paid $" + (cents / 100.0) + " using Stripe.");
    }
}
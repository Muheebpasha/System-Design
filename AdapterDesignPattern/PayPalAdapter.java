//Step 3: Adapters
// Adapter for PayPal
public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal;

    public PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }

    @Override
    public void pay(int amount) {
        payPal.makePayment(amount);
    }
    
}

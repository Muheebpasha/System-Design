public class PayPalCard implements Card{

    @Override
    public String getCardType() {
        return "PayPal Card";
    }

    @Override
    public void processPayment(double amount) {
       System.out.println("Processing paypal card payment of $ "+amount);
    }
    
    @Override
    public boolean validateCardDetails() {
        System.out.println("Validating PayPal Card details");
        return true;
    }
}
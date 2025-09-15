public class StripeCard implements Card {

    @Override
    public String getCardType() {
        return "Stripe Card";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe Card payment of $ "+amount);
    }

    @Override
    public boolean validateCardDetails() {
        System.out.println("Validation Stripe Card Details");
        return true;
    }

}
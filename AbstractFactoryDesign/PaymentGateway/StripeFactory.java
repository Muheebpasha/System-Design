// Concrete Factory for Stripe
public class StripeFactory implements PaymentFactory{

    @Override
    public Card createCard() {
        return new StripeCard();
    }

    @Override
    public Wallet createWallet() {
        return new StripeWallet();
    }
    
}
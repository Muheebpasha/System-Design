// Concrete Factory for PayPal
public class PayPalFactory implements PaymentFactory {
    @Override
    public Card createCard() {
        
        return new PayPalCard();
    }

    @Override
    public Wallet createWallet() {
        
        return new PayPalWallet();
    }
    
}
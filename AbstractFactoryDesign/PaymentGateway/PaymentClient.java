// Client Code
public class PaymentClient {

    private Card card;
    private Wallet wallet;

    public PaymentClient(PaymentFactory factory) {
        this.card = factory.createCard();
        this.wallet = factory.createWallet();
    }

    public void doCardPayment(double amount) {
        if(card.validateCardDetails()) {
            card.processPayment(amount);
        }
        System.out.println("Card type : "+ card.getCardType());
    }
    
    public void doWalletPayment(double amount) {
        wallet.processPayment(amount);
        System.out.println("Wallet Balance after payment: $" + wallet.checkBalance());
    }

    public void addFunds(double amount) {
        wallet.addFunds(amount);
        System.out.println("Wallet Balance after adding funds: $" + wallet.checkBalance());
    }
}

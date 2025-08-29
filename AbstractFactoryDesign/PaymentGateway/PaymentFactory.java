// Abstract Factory Interface
public interface PaymentFactory {
    Card createCard();
    Wallet createWallet();
} 
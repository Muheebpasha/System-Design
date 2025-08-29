public class Main {
    public static void main(String[] args) {
        System.out.println("Using PayPal Gateway:");
        PaymentClient client = new PaymentClient(new PayPalFactory());
        client.doCardPayment(200);
        client.doWalletPayment(100);
        client.addFunds(800);

        System.out.println("\nUsing Stripe Gateway:");
        client = new PaymentClient(new StripeFactory());
        client.doCardPayment(150);
        client.doWalletPayment(400);
        client.addFunds(1200);
    }
}
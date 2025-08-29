public class Main {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart(new PayPalAdapter(new PayPalGateway()));
        cart1.checkout(50);

        ShoppingCart cart2 = new ShoppingCart(new StripeAdapter(new StripeGateway()));
        cart2.checkout(75);
    }
}

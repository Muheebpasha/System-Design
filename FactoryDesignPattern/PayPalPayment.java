public class PayPalPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment using PayPal For $"+amount);
    }

}
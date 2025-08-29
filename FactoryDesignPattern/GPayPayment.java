public class GPayPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment using GPay For $"+amount);
    }
}

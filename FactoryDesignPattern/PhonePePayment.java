public class PhonePePayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment using PhonePe For $" +amount);
    }
}

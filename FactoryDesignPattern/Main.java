public class Main {
    public static void main(String[] args) {
        Payment payment1 = PaymentFactory.getPaymentMode("gpay");
        payment1.pay(500);
    }
}

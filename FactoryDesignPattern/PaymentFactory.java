public class PaymentFactory {

    public static Payment getPaymentMode(String type) {
        switch (type) {
            case "debit":
                return new DebiitCardPayment();
            case "gpay":
                return new GPayPayment();
            case "paypal":
                return new PayPalPayment();
            case "phonepe":
                return new PhonePePayment();        
            default:
                throw new IllegalArgumentException("Unknown Payment Method :"+type);
        }
        
    }
}
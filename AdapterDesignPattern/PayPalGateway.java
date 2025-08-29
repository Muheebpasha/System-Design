//Step 2: Adaptees (3rd Party APIs with different methods)
public class PayPalGateway {
     public void makePayment(double amountInUSD) {
        System.out.println("Paid $" + amountInUSD + " using PayPal.");
    }
}


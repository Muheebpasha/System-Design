public class DebiitCardPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Payment using Debit Card For $"+ amount);
    }
    
}

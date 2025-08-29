public class HundredRupeeHandler extends CashHandler {
    private final int denomination = 100;

    @Override
    public void dispense(int amount) {
        if(amount >= denomination) {
            int count = amount / denomination;
            int remainder = amount % denomination;

            System.out.println("Dispensing "+ count + " notes of Rs. " +denomination);
            if (remainder !=0 && nextHandler != null) {
                nextHandler.dispense(remainder);
            } else if(nextHandler != null) {
                nextHandler.dispense(amount);
            }
        }
    }
}

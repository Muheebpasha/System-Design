public class ATMMachine {
    private CashHandler handler;

    public ATMMachine(){
        this.handler = new TwoThousandRupeeHandler();
        CashHandler fiveHundred = new FiveHundredRupeeHandler();
        CashHandler twoHundred = new TwoHundredRupeeHandler();
        CashHandler hundred = new HundredRupeeHandler();
        handler.setNextHandler(fiveHundred);
        fiveHundred.setNextHandler(twoHundred);
        twoHundred.setNextHandler(hundred);
    }

    public void withdraw(int amount) {
        System.out.println("Requested amount Rs. " +amount);
        handler.dispense(amount);
    }
}

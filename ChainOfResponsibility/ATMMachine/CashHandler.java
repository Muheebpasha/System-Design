public abstract class CashHandler {
    protected CashHandler nextHandler;

    public void setNextHandler(CashHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void dispense(int amount);
}

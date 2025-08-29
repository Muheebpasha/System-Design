public class SoldOutState implements State {
    private final VendingMachine machine;

    public SoldOutState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        machine.getNotifier().notifyUser("Machine is sold out. Cannot accept coin.");
    }

    @Override
    public void ejectCoin() {
        machine.getNotifier().notifyUser("No coin to eject. Machine is sold out.");
    }

    @Override
    public void pressButton() {
        machine.getNotifier().notifyUser("Machine is sold out.");
    }

    @Override
    public void selectItem(String itemCode) {
        machine.getNotifier().notifyUser("Machine is sold out.");
    }
}

public class DispensingState implements State {
    private final VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        machine.getNotifier().notifyUser("Please wait. Dispensing in progress.");
    }

    @Override
    public void ejectCoin() {
        machine.getNotifier().notifyUser("Cannot eject coin. Dispensing in progress.");
    }

    @Override
    public void pressButton() {
        machine.getNotifier().notifyUser("Already dispensing. Please wait.");
    }

    @Override
    public void selectItem(String itemCode) {
        machine.getNotifier().notifyUser("Please wait. Dispensing current item.");
    }
}

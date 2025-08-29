public class NoCoinState implements State {
    private final VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        machine.setState(machine.getHasCoinState());
        machine.getNotifier().notifyUser("Coin Inserted.");
    }

    @Override
    public void ejectCoin() {
        machine.getNotifier().notifyUser("No Coin to eject.");
    }

    @Override
    public void pressButton() {
        machine.getNotifier().notifyUser("Insert Coin First.");
    }

    @Override
    public void selectItem(String itemCode) {
        itemCode = itemCode.toUpperCase().trim(); // normalize input

        if (!machine.hasItem(itemCode)) {
            machine.getNotifier().notifyUser("Item " + itemCode + " is not available.");
        } else {
            machine.setSelectedItem(itemCode);
            machine.getNotifier().notifyUser("Selected item: " + itemCode);
        }
    }
}

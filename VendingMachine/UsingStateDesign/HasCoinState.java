public class HasCoinState implements State {
    private final VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }    

    @Override
    public void insertCoin() {
        machine.getNotifier().notifyUser("Coin already inserted.");
    }

    @Override
    public void ejectCoin() {
        machine.setSelectedItem(null); // cancel selection if any
        machine.setState(machine.getNoCoinState());
        machine.getNotifier().notifyUser("Coin returned.");
    }

    @Override
    public void pressButton() {
        String itemCode = machine.getSelectedItem();

        if (itemCode == null) {
            machine.getNotifier().notifyUser("Please select an item before pressing the button.");
            return;
        }

        if (!machine.hasItem(itemCode)) {
            machine.getNotifier().notifyUser("Selected item is out of stock.");
            machine.setSelectedItem(null);
            return;
        }

        machine.setState(machine.getDispensingState());
        machine.getNotifier().notifyUser("Dispensing item...");
        machine.dispense();
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

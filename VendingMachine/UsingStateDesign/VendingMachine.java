import java.util.Map;

public class VendingMachine {

    private final Notifier notifier;

    // States
    private final State noCoinState;
    private final State hasCoinState;
    private final State dispensingState;
    private final State soldOutState;

    private State currentState;

    // Inventory and selection
    private final InventoryManager inventoryManager = new InventoryManager();
    private String selectedItem;

    public VendingMachine(Notifier notifier) {
        this.notifier = notifier;

        // Initialize states
        this.noCoinState = new NoCoinState(this);
        this.hasCoinState = new HasCoinState(this);
        this.dispensingState = new DispensingState(this);
        this.soldOutState = new SoldOutState(this);

        // Initial state
        this.currentState = noCoinState;
    }

    // Delegate to current state
    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void selectItem(String itemCode) {
        currentState.selectItem(itemCode);
    }

    public void pressButton() {
        currentState.pressButton();
    }

    // Dispense logic
    public void dispense() {
        if (selectedItem == null) {
            notifier.notifyUser("No item selected.");
            setState(noCoinState);
            return;
        }

        if (!hasItem(selectedItem)) {
            notifier.notifyUser("Item " + selectedItem + " is out of stock.");
            setState(hasCoinState);
            return;
        }

        Product product = inventoryManager.getProduct(selectedItem);
        inventoryManager.dispenseItem(selectedItem);

        notifier.notifyUser("Dispensing " + product.getName() +
                " ($" + product.getPrice() + "). Remaining: " + product.getQuantity());

        selectedItem = null;

        if (isAllSoldOut()) {
            setState(soldOutState);
            notifier.notifyUser("Machine is now sold out.");
        } else {
            setState(noCoinState);
        }
    }

    // Inventory
    public void addProduct(Product product) {
        inventoryManager.addProduct(product);

        if (currentState == soldOutState && !inventoryManager.isAllSoldOut()) {
            setState(noCoinState);
        }
    }

    public boolean hasItem(String itemCode) {
        Product product = inventoryManager.getProduct(itemCode);
        return product != null && product.getQuantity() > 0;
    }


    public boolean isAllSoldOut() {
        return inventoryManager.isAllSoldOut();
    }

    public Map<String, Product> getInventory() {
        return inventoryManager.getAllProducts();
    }

    // State and selection
    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getDispensingState() {
        return dispensingState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSelectedItem(String itemCode) {
        this.selectedItem = itemCode;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public Notifier getNotifier() {
        return notifier;
    }
}

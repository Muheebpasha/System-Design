public class VendingMachine {

    private MachineState currState;
    private int itemCount;

    public VendingMachine(int itemCount) {
        this.itemCount = itemCount;
        if(itemCount>0) {
            currState = MachineState.NO_COIN;
        } else {
            currState = MachineState.SOLD_OUT;
        }
    }

    public void insertCoin() {
        if(currState == MachineState.NO_COIN) {
            currState = MachineState.HAS_COIN;
            System.out.println("Inserted Coin!");
        } else if(currState == MachineState.HAS_COIN) {
            System.out.println("Coin Already Inserted!");
        } else if(currState == MachineState.DISPENSE) {
            System.out.println("Please wait, Dispensing Item!");
        } else if(currState == MachineState.SOLD_OUT) {
            System.out.println("Can't insert coin, Sold Out!");
        }
    }

    public void ejectCoin() {
        if(currState == MachineState.HAS_COIN) {
            currState = MachineState.NO_COIN;
            System.out.println("Coin returned!");
        } else if(currState == MachineState.NO_COIN) {
            System.out.println("No Coin to Eject!");
        } else if(currState == MachineState.DISPENSE) {
            System.out.println("Already dispensing!");
        } else if(currState == MachineState.SOLD_OUT) {
            System.out.println("Sold Out!");
        }
    }

    public void pressButton() {
        if(currState == MachineState.HAS_COIN) {
            currState = MachineState.DISPENSE;
            System.out.println("Button is Pressed!");
        } else if(currState == MachineState.NO_COIN) {
            System.out.println("Insert coin first!");
        } else if(currState == MachineState.DISPENSE) {
            System.out.println("Already dispensing!");
        } else if(currState == MachineState.SOLD_OUT) {
            System.out.println("Item is sold out!");
        }
    }

    private void dispense() {
        if(currState == MachineState.DISPENSE) {
            if(itemCount > 0) {
                itemCount--;
                System.out.println("Item dispense, Remaining item : "+ itemCount);
            } else {
                currState = MachineState.NO_COIN;
            }
        }
    }

    public MachineState getCurrentState() {
        return currState;
    }

    public int getItemCount() {
        return itemCount;
    }
}
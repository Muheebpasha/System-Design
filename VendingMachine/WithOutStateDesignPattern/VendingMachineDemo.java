public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(2);

        machine.insertCoin();
        machine.pressButton();
        System.out.println("****************");
        machine.insertCoin();
        machine.ejectCoin();
        System.out.println("****************");
        machine.insertCoin();
        machine.pressButton();
        System.out.println("****************");
        machine.insertCoin();
        
    }   
}

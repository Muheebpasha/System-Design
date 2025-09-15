public class Main {
    public static void main(String[] args) {
        SmartHomeSystem home = new SmartHomeSystem();

        // Connect interfaces
        home.connectInterface("Kitchen", new AlexaFactory());
        home.connectInterface("Bed Room", new AppleHomeFactory());
        home.connectInterface("Hall", new GoogleHomeFactory());

        System.out.println("\n--- Connected Devices ---");
        home.showConnectedDevices("Kitchen");
        home.showConnectedDevices("Bed Room");
        home.showConnectedDevices("Hall");

        System.out.println("\n--- Disconnect Example ---");
        home.disconnectInterface("Kitchen");
        home.showConnectedDevices("Kitchen");
    }
    
}

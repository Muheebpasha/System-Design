// ----------------- Concrete Devices -----------------

public class DoorLock implements SmartDevice {

    @Override
    public void connect() {
       System.out.println("Door Lock Connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Door Lock Disconnected"); 
    }

    @Override
    public String getName() {
       return "Door Lock";
    }
    
}

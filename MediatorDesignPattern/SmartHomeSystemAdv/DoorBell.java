public class DoorBell implements SmartDevice {

    @Override
    public void connect() {
        System.out.println("Door Bell Connected");
    }

    @Override
    public void disconnect() {
       System.out.println("Door Bell Disconnected");  
    }

    @Override
    public String getName() {
        return "Door Bell";
    }
    
}

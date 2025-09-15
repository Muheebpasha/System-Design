public class AC implements SmartDevice {

    @Override
    public void connect() {
        System.out.println("AC Connected");
    }

    @Override
    public void disconnect() {
        System.out.println("AC Disconnected");
        
    }

    @Override
    public String getName() {
        return "AC";
    }
    
}

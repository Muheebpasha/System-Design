public class Fan implements SmartDevice {

    @Override
    public void connect() {
        System.out.println("Fan Connected");
    }

    @Override
    public void disconnect() {
       System.out.println("Fan Disconnected");
    }

    @Override
    public String getName() {
        return "Fan";
    }
    
}

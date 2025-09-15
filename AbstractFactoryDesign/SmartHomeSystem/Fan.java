class Fan implements SmartDevice {
    public String getName() { return "Fan"; }
    public void connect() { System.out.println("Fan connected"); }
    public void disconnect() { System.out.println("Fan disconnected"); }
}
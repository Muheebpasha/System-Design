class AC implements SmartDevice {
    public String getName() { return "AC"; }
    public void connect() { System.out.println("AC connected"); }
    public void disconnect() { System.out.println("AC disconnected"); }
}
class Light implements SmartDevice {
    public String getName() { return "Light"; }
    public void connect() { System.out.println("Light connected"); }
    public void disconnect() { System.out.println("Light disconnected"); }
}

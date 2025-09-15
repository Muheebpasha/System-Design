class DoorBell implements SmartDevice {
    public String getName() { return "Door Bell"; }
    public void connect() { System.out.println("Door Bell connected"); }
    public void disconnect() { System.out.println("Door Bell disconnected"); }
}
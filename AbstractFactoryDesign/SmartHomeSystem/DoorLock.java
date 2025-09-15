// ----------------- Concrete Devices -----------------
class DoorLock implements SmartDevice {
    public String getName() { return "Door Lock"; }
    public void connect() { System.out.println("Door Lock connected"); }
    public void disconnect() { System.out.println("Door Lock disconnected"); }
}
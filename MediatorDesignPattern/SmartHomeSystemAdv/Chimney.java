class Chimney implements SmartDevice {
    private int level = 0;
    private boolean lightOn = false;

    public String getName() { return "Chimney"; }
    public void connect() { System.out.println("Chimney connected"); }
    public void disconnect() { System.out.println("Chimney disconnected"); }

    public void turnOn() { System.out.println("Chimney ON"); }
    public void turnOff() { System.out.println("Chimney OFF"); }
    public void levelUp() { if (level < 3) level++; System.out.println("Chimney level: " + level); }
    public void lightOn() { lightOn = true; System.out.println("Chimney light ON"); }
    public void lightOff() { lightOn = false; System.out.println("Chimney light OFF"); }
}
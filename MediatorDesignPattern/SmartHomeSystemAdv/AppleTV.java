class AppleTV implements SmartDevice {
    private int volume = 5;
    private int brightness = 3;

    public String getName() { return "Apple TV"; }
    public void connect() { System.out.println("Apple TV connected"); }
    public void disconnect() { System.out.println("Apple TV disconnected"); }

    public void turnOn() { System.out.println("Apple TV ON"); }
    public void turnOff() { System.out.println("Apple TV OFF"); }
    public void volumeUp() { volume++; System.out.println("Volume: " + volume); }
    public void volumeDown() { volume--; System.out.println("Volume: " + volume); }
    public void increaseBrightness() { if (brightness < 5) brightness++; System.out.println("Brightness: " + brightness); }
    public void decreaseBrightness() { if (brightness > 1) brightness--; System.out.println("Brightness: " + brightness); }
}
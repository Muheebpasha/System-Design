import java.util.*;

// ---------------- Mediator ----------------
interface SmartHub {
    void registerDevice(String location, SmartDevice device);
    void removeDevice(String location, SmartDevice device);
    void sendCommand(String location, String deviceName, String command);
    void showDevices(String location);
}

// ---------------- Concrete Mediator ----------------
class HomeHub implements SmartHub {
    private Map<String, List<SmartDevice>> locationDevices = new HashMap<>();

    @Override
    public void registerDevice(String location, SmartDevice device) {
        locationDevices.putIfAbsent(location, new ArrayList<>());
        locationDevices.get(location).add(device);
        System.out.println("✅ " + device.getName() + " registered in " + location);
    }

    @Override
    public void removeDevice(String location, SmartDevice device) {
        if (locationDevices.containsKey(location)) {
            locationDevices.get(location).remove(device);
            System.out.println("❌ " + device.getName() + " removed from " + location);
        }
    }

    @Override
    public void sendCommand(String location, String deviceName, String command) {
        if (!locationDevices.containsKey(location)) {
            System.out.println("⚠️ No devices found in " + location);
            return;
        }

        for (SmartDevice d : locationDevices.get(location)) {
            if (d.getName().equalsIgnoreCase(deviceName)) {
                d.execute(command);
                return;
            }
        }
        System.out.println("⚠️ Device " + deviceName + " not found in " + location);
    }

    @Override
    public void showDevices(String location) {
        if (!locationDevices.containsKey(location) || locationDevices.get(location).isEmpty()) {
            System.out.println("⚠️ No devices in " + location);
            return;
        }
        System.out.println("📍 Devices in " + location + ":");
        locationDevices.get(location).forEach(d -> System.out.println("  - " + d.getName()));
    }
}

// ---------------- Colleague Interface ----------------
interface SmartDevice {
    String getName();
    void execute(String command);
}

// ---------------- Devices ----------------
class Light implements SmartDevice {
    private boolean on = false;

    public String getName() { return "Light"; }

    public void execute(String command) {
        switch (command.toLowerCase()) {
            case "on" -> { on = true; System.out.println("💡 Light ON"); }
            case "off" -> { on = false; System.out.println("💡 Light OFF"); }
            default -> System.out.println("⚠️ Unknown command for Light");
        }
    }
}

class DoorLock implements SmartDevice {
    private boolean locked = true;

    public String getName() { return "Door Lock"; }

    public void execute(String command) {
        switch (command.toLowerCase()) {
            case "lock" -> { locked = true; System.out.println("🔒 Door Locked"); }
            case "unlock" -> { locked = false; System.out.println("🔓 Door Unlocked"); }
            default -> System.out.println("⚠️ Unknown command for Door Lock");
        }
    }
}

class AppleTV implements SmartDevice {
    private int volume = 5;
    private int brightness = 3;

    public String getName() { return "Apple TV"; }

    public void execute(String command) {
        switch (command.toLowerCase()) {
            case "on" -> System.out.println("📺 Apple TV ON");
            case "off" -> System.out.println("📺 Apple TV OFF");
            case "volume up" -> { volume++; System.out.println("🔊 Volume: " + volume); }
            case "volume down" -> { volume--; System.out.println("🔉 Volume: " + volume); }
            case "brightness up" -> { if (brightness < 5) brightness++; System.out.println("☀️ Brightness: " + brightness); }
            case "brightness down" -> { if (brightness > 1) brightness--; System.out.println("🌑 Brightness: " + brightness); }
            default -> System.out.println("⚠️ Unknown command for Apple TV");
        }
    }
}

class Chimney implements SmartDevice {
    private int level = 0;
    private boolean lightOn = false;

    public String getName() { return "Chimney"; }

    public void execute(String command) {
        switch (command.toLowerCase()) {
            case "on" -> System.out.println("🔥 Chimney ON");
            case "off" -> System.out.println("🔥 Chimney OFF");
            case "level up" -> { if (level < 3) level++; System.out.println("🔥 Chimney level: " + level); }
            case "light on" -> { lightOn = true; System.out.println("💡 Chimney Light ON"); }
            case "light off" -> { lightOn = false; System.out.println("💡 Chimney Light OFF"); }
            default -> System.out.println("⚠️ Unknown command for Chimney");
        }
    }
}

// ---------------- Smart Interfaces (Clients) ----------------
abstract class SmartInterface {
    protected SmartHub hub;
    protected String location;

    public SmartInterface(SmartHub hub, String location) {
        this.hub = hub;
        this.location = location;
    }

    public abstract String getName();

    public void sendCommand(String device, String command) {
        System.out.println("👉 " + getName() + " sending command to " + device + " in " + location);
        hub.sendCommand(location, device, command);
    }

    public void showDevices() {
        hub.showDevices(location);
    }
}

class Alexa extends SmartInterface {
    public Alexa(SmartHub hub, String location) { super(hub, location); }
    public String getName() { return "Alexa"; }
}

class GoogleHome extends SmartInterface {
    public GoogleHome(SmartHub hub, String location) { super(hub, location); }
    public String getName() { return "Google Home"; }
}

class AppleHome extends SmartInterface {
    public AppleHome(SmartHub hub, String location) { super(hub, location); }
    public String getName() { return "Apple Home"; }
}

// ---------------- Main ----------------
public class Main {
    public static void main(String[] args) {
        SmartHub hub = new HomeHub();

        // Register devices
        hub.registerDevice("Kitchen", new Chimney());
        hub.registerDevice("Kitchen", new Light());

        hub.registerDevice("Bed Room", new AppleTV());

        hub.registerDevice("Hall", new DoorLock());
        hub.registerDevice("Hall", new Light());

        // Connect smart interfaces
        SmartInterface alexa = new Alexa(hub, "Kitchen");
        SmartInterface appleHome = new AppleHome(hub, "Bed Room");
        SmartInterface googleHome = new GoogleHome(hub, "Hall");

        System.out.println("\n--- Show Devices ---");
        alexa.showDevices();
        appleHome.showDevices();
        googleHome.showDevices();

        System.out.println("\n--- Control Devices ---");
        alexa.sendCommand("Chimney", "on");
        alexa.sendCommand("Chimney", "level up");
        alexa.sendCommand("Light", "on");

        appleHome.sendCommand("Apple TV", "on");
        appleHome.sendCommand("Apple TV", "volume up");

        googleHome.sendCommand("Door Lock", "unlock");
        googleHome.sendCommand("Light", "off");
    }
}

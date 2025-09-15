import java.util.*;

// ----------------- Device Interfaces -----------------
interface SmartDevice {
    String getName();
    void connect();
    void disconnect();
}

// ----------------- Concrete Devices -----------------
class DoorLock implements SmartDevice {
    public String getName() { return "Door Lock"; }
    public void connect() { System.out.println("Door Lock connected"); }
    public void disconnect() { System.out.println("Door Lock disconnected"); }
    public void lock() { System.out.println("Door locked"); }
    public void unlock() { System.out.println("Door unlocked"); }
}

class DoorBell implements SmartDevice {
    public String getName() { return "Door Bell"; }
    public void connect() { System.out.println("Door Bell connected"); }
    public void disconnect() { System.out.println("Door Bell disconnected"); }
    public void ring() { System.out.println("Ding Dong! Someone at the door."); }
}

class AC implements SmartDevice {
    public String getName() { return "AC"; }
    public void connect() { System.out.println("AC connected"); }
    public void disconnect() { System.out.println("AC disconnected"); }
    public void turnOn() { System.out.println("AC ON"); }
    public void turnOff() { System.out.println("AC OFF"); }
}

class Fan implements SmartDevice {
    public String getName() { return "Fan"; }
    public void connect() { System.out.println("Fan connected"); }
    public void disconnect() { System.out.println("Fan disconnected"); }
    public void turnOn() { System.out.println("Fan ON"); }
    public void turnOff() { System.out.println("Fan OFF"); }
}

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

class Light implements SmartDevice {
    public String getName() { return "Light"; }
    public void connect() { System.out.println("Light connected"); }
    public void disconnect() { System.out.println("Light disconnected"); }
    public void turnOn() { System.out.println("Light ON"); }
    public void turnOff() { System.out.println("Light OFF"); }
}

// ----------------- Command Pattern -----------------
interface Command {
    void execute();
}

// Example Commands
class TurnOnLightCommand implements Command {
    private Light light;
    public TurnOnLightCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class TurnOffLightCommand implements Command {
    private Light light;
    public TurnOffLightCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

class VolumeUpAppleTVCommand implements Command {
    private AppleTV tv;
    public VolumeUpAppleTVCommand(AppleTV tv) { this.tv = tv; }
    public void execute() { tv.volumeUp(); }
}

class ChimneyLevelUpCommand implements Command {
    private Chimney chimney;
    public ChimneyLevelUpCommand(Chimney chimney) { this.chimney = chimney; }
    public void execute() { chimney.levelUp(); }
}

// ----------------- Abstract Factory -----------------
interface SmartHomeFactory {
    List<SmartDevice> createDevices();
    String getInterfaceName();
}

// Configurable Factory (Flexible)
class ConfigurableSmartHomeFactory implements SmartHomeFactory {
    private String interfaceName;
    private List<SmartDevice> devices = new ArrayList<>();

    public ConfigurableSmartHomeFactory(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void removeDevice(SmartDevice device) {
        devices.remove(device);
    }

    @Override
    public List<SmartDevice> createDevices() {
        return new ArrayList<>(devices); // defensive copy
    }

    @Override
    public String getInterfaceName() {
        return interfaceName;
    }
}

// ----------------- Mediator -----------------
class SmartHomeSystem {
    private Map<String, String> locationInterface = new HashMap<>();
    private Map<String, List<SmartDevice>> locationDevices = new HashMap<>();

    public void connectInterface(String location, SmartHomeFactory factory) {
        if (locationInterface.containsKey(location)) {
            System.out.println("❌ " + location + " already has a smart interface: " + locationInterface.get(location));
            return;
        }
        List<SmartDevice> devices = factory.createDevices();
        locationInterface.put(location, factory.getInterfaceName());
        locationDevices.put(location, devices);

        System.out.println("✅ " + factory.getInterfaceName() + " connected in " + location);
        devices.forEach(SmartDevice::connect);
    }

    public void disconnectInterface(String location) {
        if (!locationInterface.containsKey(location)) {
            System.out.println("❌ No smart interface in " + location);
            return;
        }
        System.out.println("🔌 Disconnecting " + locationInterface.get(location) + " from " + location);
        locationDevices.get(location).forEach(SmartDevice::disconnect);

        locationInterface.remove(location);
        locationDevices.remove(location);
    }

    public void showConnectedDevices(String location) {
        if (!locationInterface.containsKey(location)) {
            System.out.println("❌ No smart interface in " + location);
            return;
        }
        System.out.println("📍 " + location + " (" + locationInterface.get(location) + "):");
        locationDevices.get(location).forEach(d -> System.out.println("  - " + d.getName()));
    }

    // Mediator executes commands
    public void executeCommand(Command command) {
        System.out.print("➡️ Executing command: ");
        command.execute();
    }
}

// ----------------- Main -----------------
public class Main {
    public static void main(String[] args) {
        SmartHomeSystem home = new SmartHomeSystem();

        // Create flexible factories
        ConfigurableSmartHomeFactory alexaFactory = new ConfigurableSmartHomeFactory("Alexa");
        alexaFactory.addDevice(new Chimney());
        alexaFactory.addDevice(new Light());

        ConfigurableSmartHomeFactory appleFactory = new ConfigurableSmartHomeFactory("Apple Home");
        appleFactory.addDevice(new AppleTV());

        ConfigurableSmartHomeFactory googleFactory = new ConfigurableSmartHomeFactory("Google Home");
        googleFactory.addDevice(new DoorBell());
        googleFactory.addDevice(new DoorLock());
        googleFactory.addDevice(new AC());
        googleFactory.addDevice(new Fan());
        googleFactory.addDevice(new Light());

        // Connect interfaces
        home.connectInterface("Kitchen", alexaFactory);
        home.connectInterface("Bed Room", appleFactory);
        home.connectInterface("Hall", googleFactory);

        System.out.println("\n--- Connected Devices ---");
        home.showConnectedDevices("Kitchen");
        home.showConnectedDevices("Bed Room");
        home.showConnectedDevices("Hall");

        System.out.println("\n--- Command Pattern Demo ---");
        Light kitchenLight = new Light();
        AppleTV bedroomTV = new AppleTV();
        Chimney kitchenChimney = new Chimney();

        Command lightOn = new TurnOnLightCommand(kitchenLight);
        Command lightOff = new TurnOffLightCommand(kitchenLight);
        Command tvVolumeUp = new VolumeUpAppleTVCommand(bedroomTV);
        Command chimneyLevelUp = new ChimneyLevelUpCommand(kitchenChimney);

        home.executeCommand(lightOn);
        home.executeCommand(lightOff);
        home.executeCommand(tvVolumeUp);
        home.executeCommand(chimneyLevelUp);

        System.out.println("\n--- Disconnect Example ---");
        home.disconnectInterface("Kitchen");
        home.showConnectedDevices("Kitchen");
    }
}


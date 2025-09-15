import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
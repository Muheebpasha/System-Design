package interfaceDevice;

import smartHome.SmartHomeDevice;

import java.util.HashSet;
import java.util.List;

public abstract class InterfaceDevice {

    String name;
    String location;
    HashSet<SmartHomeDevice> connectedSmartDevices = new HashSet<>();
    String activationKey;

    public InterfaceDevice(String name, String location, String activationKey) {
        this.name = name;
        this.location = location;
        this.activationKey = activationKey;
    }

    public List<SmartHomeDevice> getConnectedSmartDevices() {
        return connectedSmartDevices.stream().toList();
    }

    public void connectSmartDevice(SmartHomeDevice device) {
        connectedSmartDevices.add(device);
    }

    public void disconnectSmartDevice(SmartHomeDevice device) {
        connectedSmartDevices.remove(device);
    }

    @Override
    public String toString() {
        return "InterfaceDevice{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", activationKey='" + activationKey + '\'' +
                '}';
    }
}


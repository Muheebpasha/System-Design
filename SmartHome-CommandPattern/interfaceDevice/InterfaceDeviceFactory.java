package interfaceDevice;


import exception.ExistingInterfaceDeviceException;
import exception.NonExistingInterfaceDeviceException;
import java.util.HashMap;

public class InterfaceDeviceFactory {

    HashMap<String, InterfaceDevice> activationKeyDevices = new HashMap<>();

    public InterfaceDevice createInterfaceDevice(String interfaceName, String location, String activationKey) throws ExistingInterfaceDeviceException {
        if (activationKeyDevices.containsKey(activationKey)) {
            throw new ExistingInterfaceDeviceException(activationKey);
        }
        InterfaceDevice interfaceDevice = new DefaultInterfaceDevice(interfaceName, location, activationKey);
        activationKeyDevices.put(activationKey, interfaceDevice);
       // System.out.println(interfaceDevice);
        //System.out.println(activationKeyDevices);
        //System.exit(1);
        return interfaceDevice;
    }

    public InterfaceDevice getInterfaceDevice(String activationKey) throws NonExistingInterfaceDeviceException {
        if (activationKeyDevices.containsKey(activationKey))
            return activationKeyDevices.get(activationKey);
        throw new NonExistingInterfaceDeviceException(activationKey);
    }
}


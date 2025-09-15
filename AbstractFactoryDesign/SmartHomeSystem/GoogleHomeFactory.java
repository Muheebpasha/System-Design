import java.util.Arrays;
import java.util.List;

class GoogleHomeFactory implements SmartHomeFactory {
    public List<SmartDevice> createDevices() {
        return Arrays.asList(new DoorBell(), new DoorLock(), new AC(), new Fan(), new Light());
    }
    public String getInterfaceName() { return "Google Home"; }
}

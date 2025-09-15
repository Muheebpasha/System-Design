// ----------------- Abstract Factory -----------------

import java.util.List;

interface SmartHomeFactory {
    List<SmartDevice> createDevices();
    String getInterfaceName();
}

// ----------------- Concrete Factories -----------------

import java.util.Arrays;
import java.util.List;

class AlexaFactory implements SmartHomeFactory {
    public List<SmartDevice> createDevices() {
        return Arrays.asList(new Chimney(), new Light());
    }
    public String getInterfaceName() { return "Alexa"; }
}
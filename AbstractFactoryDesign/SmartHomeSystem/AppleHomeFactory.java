import java.util.Arrays;
import java.util.List;

class AppleHomeFactory implements SmartHomeFactory {
    public List<SmartDevice> createDevices() {
        return Arrays.asList(new AppleTV());
    }
    public String getInterfaceName() { return "Apple Home"; }
}
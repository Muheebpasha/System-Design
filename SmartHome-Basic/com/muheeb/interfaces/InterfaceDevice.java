
// InterfaceDevice Interface
public interface InterfaceDevice {
    void sendCommand(SmartHomeDevice device, String command);
    void receiveResponse(String response);
    String getActivationKeyword();
    String getName();
}

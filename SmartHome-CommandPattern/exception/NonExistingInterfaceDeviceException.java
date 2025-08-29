package exception;

public class NonExistingInterfaceDeviceException extends Exception {

    public NonExistingInterfaceDeviceException(String activationkey) {
        super("No Such InterfaceDevice is present with activation key : " + activationkey);
    }
}

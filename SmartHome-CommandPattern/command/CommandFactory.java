
package command;

import exception.InvalidCommandException;
import exception.UnknownCommandException;
import command.*;
import smartHome.*;

import java.util.HashMap;

public class CommandFactory {

    public InterfaceDeviceCommand getSpecialCommand(String commandString) throws UnknownCommandException {
        if (commandString.equalsIgnoreCase("I am home")) {

        } else if (commandString.equalsIgnoreCase("Leaving home")) {

        } else if (commandString.equalsIgnoreCase("Good Night")) {

        }
        throw new UnknownCommandException(commandString);
    }

    public Command getCommand(SmartHomeDevice device, String commandString) throws UnknownCommandException, InvalidCommandException {
        if (commandString.equalsIgnoreCase("ON")) {
            if(device instanceof GenericElectricDevice)
                return new OnCommand((GenericElectricDevice) device);
            throw new InvalidCommandException();
        } else if (commandString.equalsIgnoreCase("OFF")) {
            if(device instanceof GenericElectricDevice)
                return new OffCommand((GenericElectricDevice) device);
            throw new InvalidCommandException();
        }
        try {
            Integer num = Integer.valueOf(commandString);
            if (device instanceof Light) {
                return new BrightnessCommand((Light) device, commandString);
            } else if (device instanceof Fan) {
                return new FanSpeedCommand((Fan) device, commandString);
            } else
                throw new UnknownCommandException(commandString);
        } catch (Exception e) {
            if (device instanceof Light) {
                return new ColourCommand((Light) device, commandString);
            }
            throw new UnknownCommandException(commandString);
        }
    }
}

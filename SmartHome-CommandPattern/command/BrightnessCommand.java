package command;

import exception.NotPossibleBrigtnessException;
import smartHome.Light;


public class BrightnessCommand extends SmartHomeCommand {
    public BrightnessCommand(Light smartHomeDevice, String commandString) {
        super(smartHomeDevice, commandString);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        Light light = (Light) smartHomeDevice;
        try {
            light.setBrightness(Integer.valueOf(commandString));
        } catch (NotPossibleBrigtnessException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(light);
        System.out.println("----------------------------------------------");
    }
}

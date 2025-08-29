package command;
import exception.UnknownFanSpeedException;
import smartHome.Fan;
import smartHome.SmartHomeDevice;

public class FanSpeedCommand extends SmartHomeCommand {
    public FanSpeedCommand(Fan smartHomeDevice, String commandString) {
        super(smartHomeDevice, commandString);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        Fan fan = (Fan) smartHomeDevice;
        try {
            fan.setFanSpeed(Integer.valueOf(commandString));
        } catch (UnknownFanSpeedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------");
    }
}

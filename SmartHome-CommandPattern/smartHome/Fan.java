package smartHome;


import exception.UnknownFanSpeedException;

public class Fan extends GenericElectricDevice {

    Integer fanSpeed = 3;

    public Fan(String deviceName, String location) {
        super(deviceName, location);
    }

    public Integer getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(Integer fanSpeed) throws UnknownFanSpeedException {
        if (fanSpeed > 5 || fanSpeed < 1)
            throw new UnknownFanSpeedException(fanSpeed);
    }

    @Override
    public String toString() {
        return "Fan{" +
                "fanSpeed=" + fanSpeed +
                "} " + super.toString();
    }
}

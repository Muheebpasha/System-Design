package smartHome;


public class GenericElectricDevice implements SmartHomeDevice {

    private String deviceName;
    private String location;
    private Boolean onOffStatus = Boolean.FALSE;

    public GenericElectricDevice(String deviceName, String location) {
        this.deviceName = deviceName;
        this.location = location;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getOnOffStatus() {
        return onOffStatus;
    }

    @Override
    public String toString() {
        return "GenericElectricDevice{" +
                "deviceName='" + deviceName + '\'' +
                ", location='" + location + '\'' +
                ", onOffStatus=" + onOffStatus +
                '}';
    }

    public void setOnOffStatus(Boolean onOffStatus) {
        this.onOffStatus = onOffStatus;
    }
}


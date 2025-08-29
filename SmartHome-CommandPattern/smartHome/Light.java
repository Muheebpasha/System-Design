package smartHome;
import exception.NotPossibleBrigtnessException;
import exception.UnknownColorException;

public class Light extends GenericElectricDevice {
    private Integer brightness = 5;
    private Colour color = Colour.White;
    public Light(String deviceName, String location) {
        super(deviceName, location);
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) throws NotPossibleBrigtnessException {
        if(brightness > 0 && brightness <= 10)
            this.brightness = brightness;
        throw new NotPossibleBrigtnessException(brightness);
    }

    public Colour getColor() {
        return color;
    }

    public void setColor(String color) throws UnknownColorException {
        try {
            Colour newColor = Colour.valueOf(Colour.class, color);
        } catch (Exception e) {
            throw new UnknownColorException(color);
        }
    }

    @Override
    public String toString() {
        return "Light{" +
                "brightness=" + brightness +
                ", color=" + color +
                "} " + super.toString();
    }

    enum Colour {
        White, Red, Blue, Green
    }
}


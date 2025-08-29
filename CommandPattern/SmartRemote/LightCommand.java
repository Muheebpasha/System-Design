
// ----------------------------
// Concrete Command for Light
// ----------------------------

public class LightCommand implements Command {
    private Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
    public void undo(){
        light.off();
    }
}

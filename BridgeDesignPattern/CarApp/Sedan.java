package CarApp;

public class Sedan extends Car {

    public Sedan(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving an Sedan ON th Highway Road.");
    }
    
}

package CarApp;

public class SUV extends Car {

    public SUV(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving an SUV Off Road.");
    }
    
}

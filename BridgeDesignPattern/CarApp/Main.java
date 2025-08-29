package CarApp;

public class Main {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();
        Engine dieselEngine = new DieselEngine();
        Engine electricEngine = new ElectricEngine();

        Car mySedan = new Sedan(electricEngine);
        Car mySUV = new SUV(dieselEngine);
        Car yourSUV = new SUV(petrolEngine);
        mySUV.drive();
        mySedan.drive();
        yourSUV.drive();
    }
}

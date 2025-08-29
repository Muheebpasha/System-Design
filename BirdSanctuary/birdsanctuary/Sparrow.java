package birdsanctuary;

public class Sparrow implements Bird,Flyer {
    public void eat() {
        System.out.println("Sparrow is Eating");
    }
    public void fly() {
        System.out.println("Sparrow is Flying High");
    }
}
package birdsanctuary;

public class BirdZoo {
    //works for all birds
    public static void feedBird(Bird bird) {
        bird.eat();
    }
    //only works for flying birds
    public static void letItFly(Flyer bird) {
        bird.fly();
    }
}

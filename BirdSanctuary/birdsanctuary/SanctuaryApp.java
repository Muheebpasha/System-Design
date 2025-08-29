package birdsanctuary;

public class SanctuaryApp {
    public static void main(String[] args) {
        Bird sparrow = BirdFactory.getBird("sparrow");
        Bird ostrich = BirdFactory.getBird("ostrich");
        Bird penguin = BirdFactory.getBird("penguin");

        BirdZoo.feedBird(sparrow);
        BirdZoo.feedBird(ostrich);
        BirdZoo.feedBird(penguin);

        Flyer flyer = BirdFactory.getFlyer("sparrow");
        BirdZoo.letItFly(flyer);

    }
}

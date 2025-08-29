package RestaurantApp;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("American Restaurant:\n");
        AmericanRestaurant americanRestaurant = new AmericanRestaurant(new PepperoniPizza());
        americanRestaurant.deliver();
        System.out.println("\n");
        System.out.println("Italian Restaurant:\n");
        ItalianRestaurant italianRestaurant = new ItalianRestaurant(new VeggiePizza());
        italianRestaurant.deliver();
    }
}

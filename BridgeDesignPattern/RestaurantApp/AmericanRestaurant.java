package RestaurantApp;

public class AmericanRestaurant extends Restaurant {

    AmericanRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void addSauce() {
        pizza.setSauce("Everything");
    }

    @Override
    public void addToppings() {
        pizza.setToppings("Super Secret Recipe");
    }

    @Override
    public void makeCrust() {
        pizza.setCrust("Thick");   
    }
    
}

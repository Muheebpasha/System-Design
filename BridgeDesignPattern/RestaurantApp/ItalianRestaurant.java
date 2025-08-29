package RestaurantApp;

public class ItalianRestaurant extends Restaurant {
    public ItalianRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void addSauce() {
        pizza.setSauce(null);   
    }

    @Override
    public void addToppings() {
        pizza.setToppings("Oil");
    }

    @Override
    public void makeCrust() {
       pizza.setCrust("Thin"); 
    }
    
}

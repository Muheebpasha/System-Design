public class Main {
    public static void main(String[] args) {
        MenuItem burger = new MenuItem("Burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", 7.99);
        MenuItem coffee = new MenuItem("Coffee", 2.99);

        Menu lunchMenu = new Menu("Lunch Menu");
        lunchMenu.add(burger);
        lunchMenu.add(pizza);

        Menu drinksMenu = new Menu("Drinks Menu");
        drinksMenu.add(coffee);

        Menu mainMenu = new Menu("Main Menu");
        mainMenu.add(lunchMenu);
        mainMenu.add(drinksMenu);

        mainMenu.display();
    }
}


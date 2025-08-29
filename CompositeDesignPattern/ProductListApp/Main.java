public class Main {
     public static void main(String[] args) {
        Category electronics = new Category("Electronics");

        Category mobiles = new Category("Mobiles");
        mobiles.add(new Product("iPhone 13", 999));
        mobiles.add(new Product("Samsung Galaxy S21", 899));

        Category laptops = new Category("Laptops");
        laptops.add(new Product("MacBook Pro", 1999));
        laptops.add(new Product("Dell XPS 13", 1499));

        Category smartWatches = new Category("Smart Watches");
        smartWatches.add(new Product("NoiseFit Halo", 58));
        smartWatches.add(new Product("Galaxy Watch Samsung", 70));
        
        electronics.add(mobiles);
        electronics.add(laptops);
        electronics.add(smartWatches);
        electronics.display(0);

        System.out.println("\nTotal price of electronics category: $" + electronics.getPrice());

        Category fashions = new Category("Fashions");
        Category mensTShirts = new Category("Mens T-Shirts");
        mensTShirts.add(new Product("Men Solid Polo Neck Cotton Blend Maroon T-Shirt", 20));
        mensTShirts.add(new Product("Men Striped Polo Neck Polycotton Black, White T-Shirt" , 21));
        mensTShirts.add(new Product("Men Striped Polo Neck Cotton Blend Black, Red T-Shirt" , 18));

        Category mensJeans = new Category("Mens Jeans");
        mensJeans.add(new Product("Men Regular Mid Rise Dark Blue Jeans", 28));
        mensJeans.add(new Product("Men Regular Mid Rise Black Jeans" , 25));

        fashions.add(mensJeans);
        fashions.add(mensTShirts);
        fashions.display(0);
        
        System.out.println("\nTotal price of Fashions category: $" + fashions.getPrice());

    }
}

class Product implements Comparable<Product> {

    private int id;
    private String name;
    private int price;
    private String category;
    private double rating;

    // ---------------- Constructor ----------------
    public Product(int id, String name, int price, String category, double rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }

    // ---------------- Getters ----------------
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }
    public double getRating() { return rating; }

    // ---------------- Behavior Methods ----------------

    // Apply discount percentage
    public void applyDiscount(double percent) {
        this.price -= (this.price * percent / 100);
    }

    // Update price by new amount
    public void updatePrice(int newPrice) {
        this.price = newPrice;
    }

    // ---------------- Comparable (Default Sort = by price) ----------------
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.price, other.price);
    }

    // ---------------- equals + hashCode (recommended) ----------------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;

        Product p = (Product) obj;
        return id == p.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    // ---------------- Builder Pattern ----------------
    public static class Builder {
        private int id;
        private String name;
        private int price;
        private String category;
        private double rating;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setPrice(int price) { this.price = price; return this; }
        public Builder setCategory(String category) { this.category = category; return this; }
        public Builder setRating(double rating) { this.rating = rating; return this; }

        public Product build() {
            return new Product(id, name, price, category, rating);
        }
    }

    // ---------------- toString ----------------
    @Override
    public String toString() {
        return id + " - " + name + " - ₹" + price + 
               " - " + category + " - ⭐" + rating;
    }
}


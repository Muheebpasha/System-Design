class CarMarketDemo {
    public static void main(String[] args) {
        VehicleMarket market = new VehicleMarket();
        
        Vehicle car1 = new Vehicle("Hyundai", "Creta");
        Vehicle car2 = new Vehicle("Tata", "Nexon");

        Customer c1 = new Customer("Muheeb", "9876543210", "Delhi", car1);
        Customer c2 = new Customer("Maaz", "9123456780", "Mumbai", car2);

        market.registerObserver(c1);
        market.registerObserver(c2);

        // New car launches
        market.addNewCar(car1);
        market.addNewCar(car2);

        System.out.println("\n== Monthly EMI Reminders ==");
        market.notifyEmiReminder();

        System.out.println("\n== 3 Month Service Reminders ==");
        market.notifyServiceReminder();
    }
}

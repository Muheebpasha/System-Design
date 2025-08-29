class Customer implements Observer {
    private String customerName;
    private String phoneNumber;
    private String address;
    private Vehicle car;  // Store customer's vehicle

    public Customer(String customerName, String phoneNumber, String address, Vehicle car) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.car = car;
    }

    @Override
    public void update(String message) {
        System.out.println(customerName + " received Update: " + message);
    }

    @Override
    public void serviceReminder() {
        // Use car model name in message
        System.out.println("Hi " + customerName + ", your car " + car.getModelName() + " is due for service! 🛠️ Regular maintenance keeps your " 
                           + car.getModelName() + " running smoothly and safely.");
    }

    @Override
    public void emiReminder() {
        System.out.println(customerName + ", your EMI due hai kindly pay karein.");
    }
}

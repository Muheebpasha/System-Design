import java.util.*;

class VehicleMarket implements Subject {
    private List<Observer> customers;
    private List<Vehicle> newCars;

    public VehicleMarket() {
        customers = new ArrayList<>();
        newCars = new ArrayList<>();
    }

    public void addNewCar(Vehicle vehicle) {
        newCars.add(vehicle);
        String message = "New car launch: " + vehicle.getBrandName() + " " + vehicle.getModelName();
        notifyObservers(message);
    }

    @Override
    public void registerObserver(Observer o) {
        customers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        customers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : customers) {
            o.update(message);
        }
    }
    
    @Override
    public void notifyServiceReminder() {
        for (Observer o : customers) {
            o.serviceReminder();
        }
    }
    
    @Override
    public void notifyEmiReminder() {
        for (Observer o : customers) {
            o.emiReminder();
        }
    }
}

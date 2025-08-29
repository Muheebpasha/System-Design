public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculateCharges(ParkingTicket ticket, Double duration) {
        if (ticket != null) {
            double hourlyRate = getHourlyRateForVehicleType(ticket.getVehicle().getVehicleType());
            return duration * hourlyRate;
        }

        return 0.0; // Invalid or closed ticket, or ticket not found
    }

    // Implement a method to get the hourly rate for the specified vehicle type
    private double getHourlyRateForVehicleType(VehicleType vehicleType) {
        // Define your hourly rate logic based on the vehicle type
        // This is a simple example; you can customize the rates as needed
        switch (vehicleType) {
            case CAR:
                return 500.0; // Hourly rate for cars
            case MOTORCYCLE:
                return 200.0; // Hourly rate for motorcycles
            case BICYCLE:
                return 50.0; // Hourly rate for bicycles
            case LARGE:
                return 1500.0; // Hourly rate for large vehicles
            default:
                return 0.0; // Unknown vehicle type
        }
    }
}

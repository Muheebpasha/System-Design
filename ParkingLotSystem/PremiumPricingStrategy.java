public class PremiumPricingStrategy implements PricingStrategy {
    @Override
    public double calculateCharges(ParkingTicket ticket,Double duration) {
        if (ticket != null) {
            double premiumRate = getPremiumRate(ticket.getVehicle().getVehicleType());
            return duration * premiumRate;
        }

        return 0.0; // Invalid or closed ticket, or ticket not found
    }

    // Implement a method to get the premium rate
    private double getPremiumRate(VehicleType vehicleType) {
        double charge;
      switch (vehicleType) {
            case CAR:
                charge= 500.0; // Hourly rate for cars
            case MOTORCYCLE:
                charge= 200.0; // Hourly rate for motorcycles
            case BICYCLE:
                charge= 50.0; // Hourly rate for bicycles
            case LARGE:
                charge= 1500.0; // Hourly rate for large vehicles
            default:
                charge= 0.0; // Unknown vehicle type
        }
        return 1.5 * charge; // Premium rate is 1.5 times the regular rate
    }
}

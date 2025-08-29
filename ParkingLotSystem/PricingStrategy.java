interface PricingStrategy {
    double calculateCharges(ParkingTicket ticket, Double duration);
}

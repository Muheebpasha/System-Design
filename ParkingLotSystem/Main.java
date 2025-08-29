import java.util.*;
import java.time.Duration;

class Main {
  public static void main(String[] args) {
    // Create a ParkingLot object and perform parking lot operations in the main method
        ParkingLot parkingLot = new ParkingLot("My Parking Lot", "123 Main Street");

        // Create parking floors and gates
        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);
        Gate entryGate1 = new Gate(1, GateType.ENTRY, floor1);
        Gate entryGate2 = new Gate(2, GateType.ENTRY, floor2);

        // Add parking floors and gates to the parking lot
        parkingLot.addParkingFloor(floor1);
        parkingLot.addParkingFloor(floor2);
        parkingLot.addGate(entryGate1);
        parkingLot.addGate(entryGate2);

        // Add parking spots to the parking floors
        List<ParkingSpot> spotsFloor1 = new ArrayList<>();
        List<ParkingSpot> spotsFloor2 = new ArrayList<>();

        // Add parking spots for floor 1
        for (long i = 1; i <= 50; i++) {
            ParkingSpot spot = new ParkingSpot(i, VehicleType.CAR);
            spotsFloor1.add(spot);
        }

        // Add parking spots for floor 2
        for (long i = 1; i <= 30; i++) {
            ParkingSpot spot = new ParkingSpot(i, VehicleType.MOTORCYCLE);
            spotsFloor2.add(spot);
        }

        // Set the parking spots for the respective floors
        floor1.setParkingSpots(spotsFloor1);
        floor2.setParkingSpots(spotsFloor2);

        // Park a vehicle
        String regNo = "ABC123";
        VehicleType vehicleType = VehicleType.CAR;
        ParkingTicket ticket = parkingLot.parkVehicle(vehicleType, regNo, 1);

        if (ticket != null) {
            System.out.println("Vehicle parked. Ticket ID: " + ticket.getId());
        } else {
            System.out.println("No available spot for the vehicle type on the specified floor.");
        }
        
        Duration duration = Duration.ofHours(2);
        double durationInHours = (double)duration.toMinutes() / 60.0; // Convert to hours as a double


        // Calculate and make a payment
        if (ticket != null) {
            double parkingCharges = parkingLot.calculateCharges(ticket.getId(), duration);
            Payment payment = parkingLot.makePayment(PaymentType.CASH, ticket.getId(),parkingCharges);
            if (payment != null) {
                System.out.println("Payment made. Amount: " + payment.getAmount() + " for vehicle " + ticket.getVehicle().getVehicleType() + " and duration in HRs: "+ durationInHours);
            } else {
                System.out.println("Invalid or closed ticket.");
            }
        }

        // Unpark a vehicle
        if (ticket != null) {
            boolean isUnparked = parkingLot.unparkVehicle(ticket.getId());
            if (isUnparked) {
                System.out.println("Vehicle unparked.");
            } else {
                System.out.println("Invalid or closed ticket.");
            }
        }
    }
}

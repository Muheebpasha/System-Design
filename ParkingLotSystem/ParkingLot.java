import java.util.*;
import java.time.LocalDateTime;
import java.time.Duration;

// ParkingLot class
public class ParkingLot {
    private String name;
    private String address;

    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<ParkingTicket> activeTickets;
    private long nextTicketID = 1;
    private long nextPaymentID = 1;

    private SlotAllocationStrategy slotAllocationStrategy; 
    private PricingStrategy pricingStrategy; 


    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        this.parkingFloors = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.activeTickets = new ArrayList<>();
        this.slotAllocationStrategy = new FCFSAllocationStrategy();
        this.pricingStrategy = new HourlyPricingStrategy();
    }

    private long generateTicketID() {
        return nextTicketID++;
    }

    private long generatePaymentID() {
        return nextPaymentID++;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void addParkingFloor(ParkingFloor floor) {
        parkingFloors.add(floor);
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    // Additional methods if needed
    public Gate findGateByNumber(long gateNo) {
        for (Gate gate : gates) {
            if (gate.getGateNo() == gateNo) {
                return gate;
            }
        }
        return null; // Gate not found
    }

  // Park vehicle
  public ParkingTicket parkVehicle(VehicleType vehicleType, String regNo, long floorNumber) {
        System.out.println("Parking vehicle: " + regNo + ", Type: " + vehicleType + ", Floor: " + floorNumber);
            ParkingFloor floor = null;

    // Find the parking floor with the given floor number
    for (ParkingFloor parkingFloor : parkingFloors) {
        if (parkingFloor.getFloorNo() == floorNumber) {
            floor = parkingFloor;
            break;
        }
    }
    if (floor != null) {
        System.out.println("Floor found: " + floor.getFloorNo());
        ParkingSpot availableSpot = this.slotAllocationStrategy.allocateSlot(floor.getAvailableSpots(vehicleType));
        if (availableSpot != null) {
                availableSpot.parkVehicle();
                ParkingTicket ticket = new ParkingTicket(generateTicketID(), availableSpot, LocalDateTime.now(), new Vehicle(regNo,vehicleType), floor.selectEntryGate());
                System.out.println("Ticket created: " + ticket.getId());
                activeTickets.add(ticket);
                return ticket;
            }
        }
        return null; // No available spot on the specified floor
    }

   public double calculateCharges(long parkingTicketID, Duration duration) {
        ParkingTicket ticket = findActiveTicketByID(parkingTicketID);
        if (ticket != null) {
          double durationInHours = (double)duration.toMinutes() / 60.0;
            double parkingCharges = this.pricingStrategy.calculateCharges(ticket, durationInHours);
            return parkingCharges;
        }
        return 0.0; // Invalid or closed ticket, or ticket not found
    }
   public Payment makePayment(PaymentType paymentType, Long parkingTicketID, double parkingCharges) {
        ParkingTicket ticket = findActiveTicketByID(parkingTicketID);
        if (ticket != null) {
            Payment payment = new Payment(generatePaymentID(), ticket, parkingCharges, paymentType);
            ticket.setAmount(parkingCharges);
            return payment;
        }
        return null; // Invalid or closed ticket, or ticket not found
    }

  public boolean unparkVehicle(long parkingTicketID) {
        ParkingTicket ticket = findActiveTicketByID(parkingTicketID);
        if (ticket != null) {
            ParkingSpot spot = ticket.getParkingSpot();
            spot.vacateSpot();
            ticket.closeTicket();
            return true;
        }
        return false; // Invalid or closed ticket, or ticket not found
    }
  private ParkingTicket findActiveTicketByID(long parkingTicketID) {
        for (ParkingTicket ticket : activeTickets) {
            if (ticket.getId()== parkingTicketID) {
                return ticket;
            }
        }
        return null; // Ticket not found or already closed
    }

}

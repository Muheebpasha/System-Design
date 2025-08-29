import java.time.LocalDateTime;

// ParkingTicket class
class ParkingTicket {
    private long id;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private Gate entryGate;
    private double amount;

    public ParkingTicket(long id, ParkingSpot parkingSpot, LocalDateTime entryTime,
                         Vehicle vehicle, Gate entryGate) {
        this.id = id;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.entryGate = entryGate;
        this.amount = 0.0; // Initialize the amount to 0.0
    }

    public long getId() {
        return id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

  public void closeTicket()
  {
    System.out.println("Closing ticket " + this.id);
  }
}


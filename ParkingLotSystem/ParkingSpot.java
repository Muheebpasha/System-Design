// ParkingSpot class
class ParkingSpot {
    private long spotNo;
    private VehicleType supportedVehicleType;
    private SpotStatus status;

    public ParkingSpot(long spotNo, VehicleType supportedVehicleType) {
        this.spotNo = spotNo;
        this.supportedVehicleType = supportedVehicleType;
        this.status = SpotStatus.AVAILABLE;
    }

    public long getSpotNo() {
        return spotNo;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void parkVehicle() {
        this.status = SpotStatus.FILLED;
    }

    public void vacateSpot() {
        this.status = SpotStatus.AVAILABLE;
    }

    // Additional methods if needed
    public boolean isOccupied() {
        return status == SpotStatus.FILLED;
    }

  
}

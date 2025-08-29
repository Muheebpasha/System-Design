import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// ParkingFloor class
class ParkingFloor {
    private long floorNo;
    private List<ParkingSpot> parkingSpots;
    private List<Gate> gates;

    public ParkingFloor(long floorNo) {
        this.floorNo = floorNo;
        this.parkingSpots = new ArrayList<>();
        this.gates = new ArrayList<>();
    }

    public long getFloorNo() {
        return floorNo;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }


    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
    // Additional methods if needed
    public List<ParkingSpot> getAvailableSpots(VehicleType vehicleType) {
    List<ParkingSpot> availableSpots = new ArrayList<>();
    for (ParkingSpot spot : parkingSpots) {
        if (spot.getSupportedVehicleType() == vehicleType && spot.getStatus() == SpotStatus.AVAILABLE) {
            availableSpots.add(spot);
        }
    }
    return availableSpots;
    }

    private int lastSelectedGateIndex = -1; 
    // Initialize with an invalid index

    Gate selectEntryGate() {
        List<Gate> allGates = getGates(); 
        if (!allGates.isEmpty()) {
            // Filter the list to select only the entry gates
            List<Gate> entryGates = allGates.stream().filter(gate -> gate.getGateType() == GateType.ENTRY).collect(Collectors.toList());
            if (!entryGates.isEmpty()) {
                // Implement a round-robin selection logic for entry gates
                lastSelectedGateIndex = (lastSelectedGateIndex + 1) % entryGates.size();
                return entryGates.get(lastSelectedGateIndex);
            }
        }
        
        // Handle the case where there are no available entry gates
        return null;
    }
}

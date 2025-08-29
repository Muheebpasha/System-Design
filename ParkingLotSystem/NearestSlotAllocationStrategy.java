import java.util.*;

class NearestSlotAllocationStrategy implements SlotAllocationStrategy {

    @Override
    public ParkingSpot allocateSlot(List<ParkingSpot> availableSlots) {
        ParkingSpot nearestSlot = null;
        double minDistance = Double.MAX_VALUE;

        for (ParkingSpot slot : availableSlots) {
                if (!slot.isOccupied()) {
                    // Calculate distance from entrance (simplified as slot index)
                    double distance = availableSlots.indexOf(slot);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestSlot = slot;  
                    }
                }
            }
        return nearestSlot; 
    }
}


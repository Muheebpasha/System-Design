import java.util.*;

class FCFSAllocationStrategy implements SlotAllocationStrategy {

  @Override
  public ParkingSpot allocateSlot(List<ParkingSpot> availableSlots) {
    for (ParkingSpot slot : availableSlots) {
      if (!slot.isOccupied()) {
        return slot;
      }
    }
    return null; // No available slots
  }
}


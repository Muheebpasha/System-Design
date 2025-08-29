import java.util.*;

interface SlotAllocationStrategy { 
    ParkingSpot allocateSlot(List<ParkingSpot> availableSlots); 
}
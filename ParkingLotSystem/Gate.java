// Gate class
class Gate {
    private long gateNo;
    private GateType gateType;
    private ParkingFloor floor;

    public Gate(long gateNo, GateType gateType, ParkingFloor floor) {
        this.gateNo = gateNo;
        this.gateType = gateType;
        this.floor = floor;
    }

    public long getGateNo() {
        return gateNo;
    }

    public GateType getGateType() {
        return gateType;
    }

    public ParkingFloor getFloor() {
        return floor;
    }
}
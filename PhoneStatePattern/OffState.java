public class OffState extends State {
    public OffState(Phone phone) {
        super(phone);
    }

    public String onHome() {
        phone.setState(new LockedState(phone)); // Moving to LockedState
        return phone.turnOn(); // Turn on screen
    }

    public String onOffOn() {
        phone.setState(new LockedState(phone)); // Moving to LockedState
        return phone.turnOn(); // Same as above
    }
}

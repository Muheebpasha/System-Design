public class LockedState extends State {
    public LockedState(Phone phone) {
        super(phone);
    }

    public String onHome() {
        phone.setState(new ReadyState(phone)); // Go to unlocked state
        return phone.unlock();
    }

    public String onOffOn() {
        phone.setState(new OffState(phone)); // Go back to off state
        return phone.lock();
    }
}

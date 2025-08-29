public class ReadyState extends State {
    public ReadyState(Phone phone) {
        super(phone);
    }

    public String onHome() {
        return phone.home(); // Already unlocked, just go home
    }

    public String onOffOn() {
        phone.setState(new OffState(phone)); // Turn off phone
        return phone.lock();
    }
}

public class Phone {
    private State state;

    public Phone() {
        state = new OffState(this); // Phone starts OFF
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    // Actions Phone Can Perform
    public String lock()   { return "Locking phone and turning off the screen."; }
    public String home()   { return "Going to home screen"; }
    public String unlock() { return "Unlocking the phone to home"; }
    public String turnOn() { return "Turning screen on, Device still locked"; }
}

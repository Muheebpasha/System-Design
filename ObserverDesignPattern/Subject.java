// Subject interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
    void notifyServiceReminder();
    void notifyEmiReminder();
}

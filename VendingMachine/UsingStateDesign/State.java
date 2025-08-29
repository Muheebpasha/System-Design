public interface State {
    void insertCoin();
    void ejectCoin();
    void pressButton();
    void selectItem(String itemCode);
}

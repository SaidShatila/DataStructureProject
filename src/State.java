public enum State {
    WAITING(1),PROCESSING(2),COMPLETED(3);
    private int value;
    State(int i) {
        value=i;
    }

    public int getValue() {
        return value;
    }
}

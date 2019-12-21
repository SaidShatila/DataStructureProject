package municipality;

public class WaitTurnManager {
    private int currentNum=0;

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getNextTurn(){
        return ++currentNum;
    }
        public void reset(){
        currentNum=0;
        }
}

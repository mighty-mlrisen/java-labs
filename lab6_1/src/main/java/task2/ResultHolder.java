package task2;

public class ResultHolder {
    private int result;
    private boolean ready = false;
    private String winnerName;

    public synchronized void setResult(int r) {
        result = r;
        ready = true;
        notifyAll();
    }

    public synchronized int getResult() throws InterruptedException {
        while (!ready) {
            wait();
        }
        return result;
    }

    public synchronized boolean setWinner(String name) {
        if (winnerName == null) {
            winnerName = name;
            return true;
        }
        return false;
    }
}

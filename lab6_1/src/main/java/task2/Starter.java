package task2;


public class Starter {

    private int waitingThreads = 0;

    public synchronized void awaitStart() throws InterruptedException {
        waitingThreads++;
        if (waitingThreads < 2) {
            wait();
        } else {
            notifyAll();
        }
    }
}

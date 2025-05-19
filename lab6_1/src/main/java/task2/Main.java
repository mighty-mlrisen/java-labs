package task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Starter       starter = new Starter();
        ResultHolder  holder  = new ResultHolder();

        Worker1 w1 = new Worker1(starter, holder);
        Thread t1 = new Thread(w1);
        t1.setName("Worker1");
        t1.start();

        int result = holder.getResult();
        System.out.println("Main: получил от Worker1 число = " + result);

        Worker2 w2 = new Worker2(starter, holder, result);
        Thread t2 = new Thread(w2);
        t2.setName("Worker2");
        t2.start();
        System.out.println("Main: началась гонка");

        t1.join();
        t2.join();
        System.out.println("Main: оба рабочих потока завершились");
    }
}

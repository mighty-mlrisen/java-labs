package task2;


public class Worker2 implements Runnable {
    private final Starter starter;
    private final ResultHolder holder;
    private final int n;

    public Worker2(Starter s, ResultHolder h,int n) {
        this.starter = s;
        this.holder  = h;
        this.n= n;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            starter.awaitStart();
        } catch (InterruptedException e) {
            return;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
            Thread.yield();
        }

        if (holder.setWinner(name)) {
            System.out.println(name+  " - (победитель)"+ " завершил sum=" + sum);
        } else {
            System.out.println(name + " завершил sum=" + sum);
        }
    }
}

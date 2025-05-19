package task2;

public class Worker1 implements Runnable{
    private final Starter starter;
    private final ResultHolder holder;

    public Worker1(Starter s, ResultHolder h) {
        this.starter = s;
        this.holder  = h;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int result = 0;
        for (int i = 1; i <= 100; i++) result += i;
        System.out.println(name + ": вычислил " + result);
        holder.setResult(result);

        try {
            starter.awaitStart();
        } catch (InterruptedException e) {
            return;
        }
        long sum = 0;
        for (int i = 0; i < result; i++) {
            sum += i;
            try { Thread.sleep(1); } catch (InterruptedException ignored) {}
        }
        if (holder.setWinner(name)) {
            System.out.println(name +  " - (победитель)"+ " завершил sum=" + sum);
        } else {
            System.out.println(name + " завершил sum=" + sum);
        }
    }
}


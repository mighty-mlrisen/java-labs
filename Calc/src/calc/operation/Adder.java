package calc.operation;

public class Adder {
    private short sum;

    public Adder() {
        sum = 0;
    }

    public Adder(short a) {
        this.sum = a;
    }

    public void add(short b) {
        sum += b;
    }

    public short getSum() {
        return sum;
    }
}
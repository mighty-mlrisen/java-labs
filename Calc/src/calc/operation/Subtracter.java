package calc.operation;

public class Subtracter {
    private short result;

    public Subtracter(short start) {
        this.result = start;
    }

    public void subtract(short num) {
        result -= num;
    }

    public short getResult() {
        return result;
    }
}

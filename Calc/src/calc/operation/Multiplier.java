package calc.operation;

public class Multiplier {
    private short result;

    public Multiplier() {
        this.result = 1; 
    }

    public void multiply(short num) {
        result *= num;
    }

    public short getResult() {
        return result;
    }
}

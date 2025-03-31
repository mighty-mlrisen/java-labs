package calc.operation;

public class Divider {
    private short result;

    public Divider(short start) {
        this.result = start;
    }

    public void divide(short num) {
        if (num != 0) {
            result /= num;
        } else {
            System.out.println("Ошибка: деление на ноль!");
        }
    }

    public short getResult() {
        return result;
    }
}


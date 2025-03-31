package calc;

import calc.operation.*;

public class Calculator {

    public short sum(short... numbers) {
        Adder adder = new Adder();
        for (short num : numbers) {
            adder.add(num);
        }
        return adder.getSum();
    }

    public short subtract(short first, short... numbers) {
        Subtracter subtracter = new Subtracter(first);
        for (short num : numbers) {
            subtracter.subtract(num);
        }
        return subtracter.getResult();
    }

    public short multiply(short... numbers) {
        Multiplier multiplier = new Multiplier();
        for (short num : numbers) {
            multiplier.multiply(num);
        }
        return multiplier.getResult();
    }

    public short divide(short first, short... numbers) {
        Divider divider = new Divider(first);
        for (short num : numbers) {
            divider.divide(num);
        }
        return divider.getResult();
    }

    public short shiftRight(short a) {
        return Shifter.shiftRight(a);
    }
}

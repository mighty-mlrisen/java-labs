package calc;

public class Calc {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Calculator calc = new Calculator();
        short a = 20;
        short b = 5;
        short c = 2;

        System.out.println("20 + 5 + 2 = " + calc.sum(a, b, c));
        System.out.println("20 - 5 - 2 = " + calc.subtract(a, b, c));
        System.out.println("20 * 5 * 2 = " + calc.multiply(a, b, c));
        System.out.println("20 / 5 / 2 = " + calc.divide(a, b, c));
        System.out.println("Сдвиг 20 вправо: " + calc.shiftRight(a));
    }
}
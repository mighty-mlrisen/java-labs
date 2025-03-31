package code.property;

import java.util.Objects;

public class Car extends Property {
    private double volume;
    private int year;

    public Car(double worth, double volume, int year) {
        super(worth);
        this.volume = volume;
        this.year = year;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public double calculateTax() {
        return (this.getVolume() / 10) * getWorth();
    }

    @Override
    public String toString() {
        return super.toString() + " | Car { volume=" + getVolume() + ", year=" + getYear() + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Double.compare(car.getVolume(), this.getVolume()) == 0 &&
                this.getYear() == car.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, year);
    }
}


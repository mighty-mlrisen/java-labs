package code.property;

import java.util.Objects;

public class Apartment extends Property {
    private String address;
    private double square;

    public Apartment(double worth, String address, double square) {
        super(worth);
        this.address = address;
        this.square = square;
    }

    public String getAddress() {
        return this.address;
    }

    public double getSquare() {
        return this.square;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public double calculateTax() {
        return (this.getWorth() / 1000) * getSquare();
    }

    @Override
    public String toString() {
        return super.toString() + " | Apartment { address='" + getAddress() + "', square=" + getSquare() + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Apartment apartment = (Apartment) obj;
        return Double.compare(apartment.getSquare(), this.getSquare()) == 0 &&
                this.getAddress().equals(apartment.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, square);
    }
}

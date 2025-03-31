package code.property;

import java.util.Objects;

public class CountryHouse extends Property {
    private double squareH;
    private double squareT;

    public CountryHouse(double worth, double squareH, double squareT) {
        super(worth);
        this.squareH = squareH;
        this.squareT = squareT;
    }

    public double getSquareH() {
        return this.squareH;
    }

    public void setSquareH(double squareH) {
        this.squareH = squareH;
    }

    public double getSquareT() {
        return this.squareT;
    }

    public void setSquareT(double squareT) {
        this.squareT = squareT;
    }

    @Override
    public double calculateTax() {
        return ((this.getSquareT() / 5000) * getWorth()) + ((this.getSquareH() / 100) * getWorth());
    }

    @Override
    public String toString() {
        return super.toString() + " | CountryHouse { squareH=" + getSquareH() + ", squareT=" + getSquareT() + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        CountryHouse countryHouse = (CountryHouse) obj;
        return Double.compare(countryHouse.getSquareH(), this.getSquareH()) == 0 &&
                Double.compare(countryHouse.getSquareT(), this.getSquareT()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), squareT, squareH);
    }
}


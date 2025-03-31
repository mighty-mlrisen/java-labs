package code.property;

import java.util.Objects;

public abstract class Property {
    private double worth;

    public Property(double worth) {
        this.worth = worth;
    }

    public double getWorth() {
        return this.worth;
    }

    public void setWorth(double worth) {
        this.worth = worth;
    }

    public abstract double calculateTax();

    public void sell() {
        System.out.println("Property sold!");
    }

    public void transfer() {
        System.out.println("Property transferred!");
    }

    @Override
    public String toString() {
        return "Property { worth=" + getWorth() + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null && this.getClass() != obj.getClass()) {
            return false;
        }
        Property property = (Property) obj;
        return (Double.compare(this.getWorth(), property.getWorth())) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(worth);
    }
}
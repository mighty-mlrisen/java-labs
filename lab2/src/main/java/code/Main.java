package code;

import code.property.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Property[] properties = {
                new Apartment(500000, "123 Main St", 50),
                new Car(20000, 3.5, 2018),
                new CountryHouse(100000, 100, 200),
                new Apartment(300000, "456 Elm St", 60),
                new Car(30000, 3.0, 2018),
                new CountryHouse(150000, 150, 300),
                new Car(30000, 3.0, 2018)
        };

        ArrayList<Property> propertiesUnique = new ArrayList<>();
        for (Property property : properties) {
            if (!propertiesUnique.contains(property)) {
                propertiesUnique.add(property);
            }
        }

        for (Property property : propertiesUnique) {
            System.out.println(property.toString() + " | Tax: " + property.calculateTax());
        }
    }
}

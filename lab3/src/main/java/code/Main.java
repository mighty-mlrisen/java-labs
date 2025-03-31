package code;
import java.util.*;

import code.property.*;
import code.smart.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("1 - lab3");
        System.out.println("2 - lab3_a");
        System.out.print("Введите номер: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a == 1) {
            Main.run3();
        } else {
            Main.run3a();
        }
    }

    public static void run3() {
        Taxable[] propertiesArray = {
                new Apartment(500000, "123 Main St", 50),
                new Car(20000, 3.5, 2018),
                new CountryHouse(100000, 100, 200),
                new Apartment(300000, "456 Elm St", 60),
                new Car(30000, 3.0, 2018),
                new CountryHouse(150000, 150, 300),
                new Car(30000, 3.0, 2018)
        };

        List<Taxable> propertiesList = new ArrayList<>();

        for (Taxable property : propertiesArray) {
            if (!propertiesList.contains(property)) {
                propertiesList.add(property);
            }
        }

        for (Taxable property : propertiesList) {
            System.out.println(property.toString() + " | Tax: " + property.calculateTax());
        }
    }

    public static void run3a() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(-5, 15, 2, -1, 7, 15, 36));

        CollectionUtils test = new CollectionUtils();

        int result = test.countCommon(list1, list2);
        System.out.println("Количество совпадающих элементов: " + result);
    }
}

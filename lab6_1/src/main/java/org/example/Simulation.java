package org.example;

import java.util.HashMap;
import java.util.Map;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        int totalCars = 30;
        CarSharing service = new CarSharing(totalCars);

        Thread[] clients = new Thread[24];
        for (int i = 0; i < 24; i++) {
            Thread.sleep(100); // 1 час = 100 мс
            clients[i] = new Thread(new Client(service, i + 1));
            clients[i].start();
        }

        for (Thread t : clients) {
            t.join();
        }

        System.out.println("\nКлиентов обслужено: " + service.getServedClients());
        System.out.println("Статистика по длительности (часов → число):");
        for (Map.Entry<Integer, Integer> e : service.getStats().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList()) {
            System.out.printf("%2d ч → %2d%n", e.getKey(), e.getValue());
        }
    }
}

package org.example;

import java.util.HashMap;
import java.util.Map;

public class CarSharing {
    private int availableCars;
    private final Map<Integer, Integer> stats = new HashMap<>();
    private int servedClients = 0;

    public CarSharing(int totalCars) {
        this.availableCars = totalCars;
    }

    public synchronized boolean tryRentCar(int durationHours) {
        if (availableCars == 0) return false;
        availableCars--;
        stats.merge(durationHours, 1, (oldValue, newValue) -> oldValue + newValue);
        servedClients++;
        return true;
    }

    public synchronized void returnCar() {
        availableCars++;
    }

    public Map<Integer, Integer> getStats() {
        return stats;
    }

    public int getServedClients() {
        return servedClients;
    }
}

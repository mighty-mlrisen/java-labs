package org.example;

import java.util.Random;


public class Client implements Runnable {
    private static final Random R = new Random();
    private static final int MIN = 4, MAX = 48, STEP = 2;
    private final CarSharing service;
    private final int id;

    public Client(CarSharing service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public void run() {
        int duration = MIN + STEP * R.nextInt((MAX - MIN) / STEP + 1);
        if (service.tryRentCar(duration)) {
            System.out.printf("Клиент %02d взял машину на %2d ч%n", id, duration);
            try {
                Thread.sleep(duration * 100);
            } catch (InterruptedException ignored) {}
            service.returnCar();
        } else {
            System.out.printf("Клиент %02d ушёл — машин нет%n", id);
        }
    }
}

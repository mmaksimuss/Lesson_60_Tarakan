package ait.race.tarakan;

import java.util.Random;

public class Tarakan extends Thread {
    private static int counter = 1;
    private int number;
    public int distance;
    private int currentPosition;

    public Tarakan(int distance) {
        this.number = counter++;
        this.distance = distance;
    }

    @Override
    public void run() {
         currentPosition = 0;
        while (currentPosition < distance) {
            System.out.println("Tarakan #" + number + " ran lap " + currentPosition);
            try {
                Thread.sleep(new Random().nextInt(4) + 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentPosition++;
        }
        System.out.println("Tarakan #" + number + " has finished the race!");
    }

    public int getNumber() {
        return number;
    }
    public int getCurrentPosition() {
        return currentPosition;
    }


}
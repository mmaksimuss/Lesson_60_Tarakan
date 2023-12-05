package ait.race;

import ait.race.tarakan.Tarakan;

import java.util.Scanner;

public class TarakanRaceAppl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tarakans: ");
        int numberOfTarakans = scanner.nextInt();
        System.out.print("Enter the distance (number of Cycles): ");
        int distance = scanner.nextInt();
        Tarakan[] tarakans = new Tarakan[numberOfTarakans];
        for (int i = 0; i < numberOfTarakans; i++) {
            tarakans[i] = new Tarakan(distance);
        }
        for (int i = 0; i < numberOfTarakans; i++) {
            tarakans[i].start();
        }
        for (int i = 0; i < numberOfTarakans; i++) {
            try {
                tarakans[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int winner = 0;
        int minPosition = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfTarakans; i++) {
            if (tarakans[i].getCurrentPosition() < minPosition) {
                minPosition = tarakans[i].getCurrentPosition();
                winner = tarakans[i].getNumber();
            }

        }
        System.out.println("Congratulations to tarakan #" + winner + " winner");
    }

}

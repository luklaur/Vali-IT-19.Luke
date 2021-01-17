package ee.bcs.valiit.tasks.audacity;

import java.util.Scanner;

public class NumbersGame {
    // What's the numbers, Mason?
    public static int playNumbersGame() {


        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;
        int yourGuess = 0;

        System.out.println("Ma valisin suvalise numbri ühest sajani.");
        System.out.println("Arva ära, mis numbri ma valisin!");
//        System.out.println(randomNumber);

        Scanner scanner = new Scanner(System.in);
        for (
                int i = 10;
                i > 0; i--) {
            System.out.println("Saad veel " + i + " korda proovida.");
            int guess = scanner.nextInt();
            System.out.println("Sa pakkusid " + guess + ".");

            if (randomNumber < guess) {
                System.out.println("Õige number on väiksem kui " + guess + ".");
            } else if (randomNumber > guess) {
                System.out.println("Õige number on suurem kui " + guess + ".");
            }
            if (randomNumber == guess) {
                hasWon = true;
                // guess value is stored in int yourGuess
                // so it could be used outside this variable scope
                yourGuess = guess;
                break;
            }
        }
        if (hasWon) {
            System.out.println("Ära arvasid! Õige number on " + yourGuess + ".");
        } else {
            System.out.println("Mäng läbi! Kaotasid");
            System.out.println("Õige number oli " + randomNumber + ".");
        }
        return 0;
    }
}
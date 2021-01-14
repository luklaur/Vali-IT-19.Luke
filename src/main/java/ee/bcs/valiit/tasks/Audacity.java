package ee.bcs.valiit.tasks;

import java.util.Scanner;

public class Audacity {

    public static void main(String[] args) {

        System.out.println(playNumbersGame());
//        System.out.println(findLongestName(new String[]{"Jack", "Paul", "Larry", "Mary"}));
//        System.out.println(searchForMax(new int[]{2, 4, 6, 8}));
//        System.out.println(searchForMin(new int[]{2, 4, 6, 8}));
//        System.out.println(average(new double[]{75, 73, 72, 80}));


    }

    private static int playNumbersGame() {


        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;
        int yourGuess = 0;

        System.out.println("Ma valisin suvalise numbri ühest sajani.");
        System.out.println("Arva ära, mis numbri ma valisin!");
//        System.out.println(randomNumber);

        Scanner scanner = new Scanner(System.in);
        for (int i = 10; i > 0; i--) {
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

    private static String findLongestName(String[] names) {
        //TODO AUDACITY harjutus
        //leia massiivist pikim nimi
        int size = names.length;
        String longestName = names[0];
        for (int i = 1; i < size; i++) {
            // >= tiebreaker
            if (names[i].length() >= longestName.length()) {
                longestName = names[i];
            }
        }
        return longestName;
    }

    private static int searchForMax(int[] numbers) {
        // TODO AUDACITY harjutus
        // leiab massiivist suurima numbri ja tagastab selle
        // ainuke erinevus miniga on > märk
        int size = numbers.length;
        int max = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    private static int searchForMin(int[] numbers) {
        // TODO AUDACITY harjutus
        // leiab massiivist väikseima numbri ja tagastab selle
        // ainuke erinevus maxiga on < märk
        int size = numbers.length;
        int min = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    private static double average(double[] numbers) {
        // TODO AUDACITY harjutus
        // arvuta massiivi keskmine
        // kasuta double, et saada täpne tulemus
        int size = numbers.length;
        double total = 0;
        for (int i = 0; i < size; i++) {
            // liidab kõik arvud massiivis
            // ja talletab need totalis
            total += numbers[i];
        }
        // jagab summa massiivi pikkusega
        double average = total / size;
        return average;
    }


}

package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main(String[] args) {

        System.out.println(playNumbersGame());
    }

    private static int playNumbersGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks

        // selle ma kirjutasin Audacity kursuse järgi maha ja modisin

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


    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        return 0;
    }


    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis
        // (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        // tekitada morse tõlk

//        HashMap<String, String> pattern = new HashMap<>();
//        pattern.put("a", ".-");
//        pattern.put("b", "-...");
//        pattern.put("c", "-.-.");
//        pattern.put("d", "-..");
//        pattern.put("e", ".");
//        pattern.put("f", "..-.");
//        pattern.put("g", "--.");
//        pattern.put("h", "....");
//        pattern.put("i", "..");
//        pattern.put("j", ".---");
//        pattern.put("k", "-.-");
//        pattern.put("l", ".-..");
//        pattern.put("m", "--");
//        pattern.put("n", "-.");
//        pattern.put("o", "---");
//        pattern.put("p", ".--.");
//        pattern.put("q", "--.-");
//        pattern.put("r", ".-.");
//        pattern.put("s", "...");
//        pattern.put("t", "-");
//        pattern.put("u", "..-");
//        pattern.put("v", "...-");
//        pattern.put("w", ".--");
//        pattern.put("x", "-..-");
//        pattern.put("y", "-.--");
//        pattern.put("z", "--..");
//        pattern.put(" ", " ");
//

//    }
        return "";
    }
}

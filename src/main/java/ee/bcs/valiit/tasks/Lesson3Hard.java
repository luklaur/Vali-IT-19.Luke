package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main(String[] args) {

//        System.out.println(playNumbersGame());
//        System.out.println("Sum is " + evenFibonacci(10));
        System.out.println(morseCode("SOS"));
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


        int total = 0;
        int a = 0;
        int b = 1;
        // alustab nullist, laseb kuni x, liidab iga kord +1
        for (int i = 0; i < x; i++) {
//            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
            // kui b on paaris siis liidab selle
            if (b % 2 == 0) {
                total += b;
            }
        }
        return total;
    }


    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis
        // (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        // tekitada morse tõlk

        String textToLow = text.toLowerCase(Locale.ROOT);
        StringBuilder morse = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        map.put("a", ".-");
        map.put("b", "-...");
        map.put("c", "-.-.");
        map.put("d", "-..");
        map.put("e", ".");
        map.put("f", "..-.");
        map.put("g", "--.");
        map.put("h", "....");
        map.put("i", "..");
        map.put("j", ".---");
        map.put("k", "-.-");
        map.put("l", ".-..");
        map.put("m", "--");
        map.put("n", "-.");
        map.put("o", "---");
        map.put("p", ".--.");
        map.put("q", "--.-");
        map.put("r", ".-.");
        map.put("s", "...");
        map.put("t", "-");
        map.put("u", "..-");
        map.put("v", "...-");
        map.put("w", ".--");
        map.put("x", "-..-");
        map.put("y", "-.--");
        map.put("z", "--..");
        map.put(" ", " ");

        String translation = "";
        for (int i = 0; i < text.length(); i++) {
            // mis see substring loogika siin on???
            String key = textToLow.substring(i, i + 1);
            translation += map.get(key) + " ";
        }
        return translation;
    }

}

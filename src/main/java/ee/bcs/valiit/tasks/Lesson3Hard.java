package ee.bcs.valiit.tasks;

import java.util.Random;

public class Lesson3Hard {
    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        return 0;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
    }

//    public static String morseCode(String text) {
    // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
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
//        return "";
//    }

}

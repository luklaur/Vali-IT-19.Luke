package ee.bcs.valiit.tasks;

import java.util.*;

public class Lesson2 {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
//        exercise1();
//        exercise2(5);
//        exercise3(3, 3);
//        exercise4(20);
        System.out.println(exercise5(1, 10));

    }

    // TODO loo 10 elemendile täisarvude massiv (massiiv on array)
    // TODO loe sisse konsoolist 10 täisarvu (kasuta scannerit)
    // TODO trüki arvud välja vastupidises järiekorras
    public static void exercise1() {
        Scanner scanner = new Scanner(System.in);
        // initialize array, 10 kohta (0-9)
        int[] täisarvud = new int[10];
        // alusta numbrite sisse skännimist kohalt 0;
        // liigu kuni 9ndani
        // iga kord +1
        for (int i = 0; i < 10; i++) {
            System.out.println("Sisesta number!");
            täisarvud[i] = scanner.nextInt();
        }
        // alusta nr välja printimist arrayst 10ndalt kohalt (9)
        // jätka kuni kohani 0
        // iga kord -1
        System.out.println("Numbrid tagurpidi on:");
        for (int i = 9; i >= 0; i--) {
            System.out.print(täisarvud[i] + " ");
        }

    }

    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static void exercise2(int x) {
        // alusta 1st;
        // jätka kuni i<=x*2, sest i<=x toob välja ainult 4 paarisarvu
        // sest kui i<=x siis x väärtus läheb enne suuremaks
        // kui loop jõuab ettenähtud arvu täisarve välja printida
        // kontrolli if vastavust
        // liida +1
        for (int i = 1; i <= x * 2; i++) {
            //if number%2 == 0 it means its an even number
            // kui on täisarv siis prindi välja
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada tabeli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    public static void exercise3(int x, int y) {

        // lisa igal ringil reavahe
        for (int j = 1; j <= x; j++) {
            System.out.println();
            // lisa igal ringil reale uus korrutaja
            for (int i = 1; i <= y; i++) {
                System.out.print(i * j + " ");
                // 1. loop: 1*1, 2*1, 3*1 (tagasi üles ja reavahe)
                // 2. loop: 1*2, 2*2, 3*2 (tagasi üles ja reavahe)
                // 3. loop: 1*3, 2*3, 3*3 (tagasi üles ja reavahe)
                // 4. loop: i on suurem kui y, stop
            }
        }
    }


    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element
    public static int exercise4(int n) {

        int a = 0;
        int b = 1;
        // alustab nullist, laseb kuni n, liidab iga kord +1
        for (int i = 0; i <= n; i++) {
            System.out.print(a + " ");
            // peale a printimist muudab a ja b väärtust
            // loop nr3 ? näide:
            int c = a + b; // c = 2 + 3
            a = b; // a = 2
            b = c; // b = 5
        }
        return b;
    }


    public static String exercise5(int x, int y) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        // TODO 1 (tee alamfunktsioon) mis leiab 3n+1 sequenci pikkuse
        // kui on paaris / 2 kui on paaritu *3+1
        // TODO 2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse


        int maxLength = 0;
        for (int i = x; i <= y; i++) {
            // võtab seqLenght väärtuse ja uuendab selle
            int seqLength = muutujaLength(i);
            // võrdleb ja uuendab maxLenght
            if (seqLength > maxLength) {
                maxLength = seqLength;
            }
        }
        return x + " " + y + " " + maxLength;
    }

    public static int muutujaLength(int n) {
        int count = 1;
        while (n > 1) {
            count++;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
        }
        return count; // annab väärtuse muutujaLenght'le
    }

}

// see osa oli mul pm õige, aga liiga keeruliselt kirjutatud
//        // loop counter
//        int countI = 1;
//        // while n != 1 repeat loop, if n == 1 then stop
//        while (!(i == 1)) {
//            countI++;
//            // if n is odd
//            if (i % 2 != 0) {
//                i = (i * 3) + 1;
//                // else n is even
//            } else {
//                i /= 2;
//            }







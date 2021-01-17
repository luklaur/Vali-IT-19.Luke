package ee.bcs.valiit.tasks.audacity;

import java.util.Scanner;

public class Audacity {

    String acctNumber;
    double balance;

    public static void main(String[] args) {

        /*Calculator*/
        System.out.println(Calculator.liida(5, 10));
        System.out.println(Calculator.lahuta(5, 10));
        System.out.println(Calculator.korruta(5, 10));
        System.out.println(Calculator.jaga(5, 10));

        /*Person näide*/
        person();

        /*Massiivi näited*/
        System.out.println(Massiiv.findLongestName(new String[]{"Jack", "Paul", "Larry", "Mary"}));
        System.out.println(Massiiv.searchForMax(new int[]{2, 4, 6, 8}));
        System.out.println(Massiiv.searchForMin(new int[]{2, 4, 6, 8}));
        System.out.println(Massiiv.average(new double[]{75, 73, 72, 80}));

        /*NumbersGame*/
        System.out.println(NumbersGame.playNumbersGame());
    }

    private static void person() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        // Print the values of both counters
        System.out.println("(localCount " + person4.localCount + ", instanceCount " + Person.instanceCount + ")");
    }
}

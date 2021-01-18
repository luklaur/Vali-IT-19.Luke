package ee.bcs.valiit.tasks;

public class Lesson1MathUtil {
    private String test;

    // TODO kirjuta ise (if/else) ära kasuta java.lang.Math
    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
        // selleks, et programm tööle läheks
        // peab main methodis midagi kirjas olema!

//        System.out.println(minOf2(7, 8));
//        System.out.println(minOf2(3, 5));
//        System.out.println(maxOf2(7, 8));
//        System.out.println(maxOf2(3, 5));
//        System.out.println(abs(-8));
//        System.out.println(minOf3(4, 4, 5));
//        System.out.println(maxOf3(5, 5, 4));

    }

    // TODO tagasta a ja b väikseim väärtus
    public static int minOf2(int a, int b) {

        if (a < b) {
            return a;
        } else {
            return b;
        }
    }


    // TODO tagasta a ja b suurim väärtus
    public static int maxOf2(int a, int b) {

        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            a = a * -1;
            return a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        // even
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int minOf3(int a, int b, int c) {

        // võrdsed numbrid <= / >=
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int maxOf3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

}


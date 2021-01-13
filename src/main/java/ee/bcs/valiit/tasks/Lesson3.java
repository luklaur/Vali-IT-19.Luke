package ee.bcs.valiit.tasks;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;


public class Lesson3 {
    public static void main(String[] args) {
//        System.out.println(sum(new int[]{2, 4, 6, 8, 10, 12, 14}));
//        System.out.println(factorial(5));
        System.out.println(sort(new int[]{5, 6, 4, 1, 7, 8, 2, 3}));
//        System.out.println(reverseString("Your text here"));
//        System.out.println(isPrime(7));
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x

        int add = 0;
        for (int i = 0; i < x.length; i++) {
            // kuni i < array pikkusest
            // igal ringil liidab add'le
            // järgmise array koha väärtuse
            add += x[i];
        }
        return add;

    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
//algus*loop counter >   tulemus*loopcounter >  tulemus*loopcounter
//1*1=1              >   1*2=2               >  2*3=6 > 6*4=24 > 24*5=120
        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
        // otsida välja array käsklused


        System.out.println("Array elements before sorting:");

        System.out.println( int[]);


        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {      //swap elements if not in order
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        //print sorted array
        System.out.println("Array sorted in ascending order: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        return new int[0];
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        return "";
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        return false;
    }
}

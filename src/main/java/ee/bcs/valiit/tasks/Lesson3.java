package ee.bcs.valiit.tasks;

public class Lesson3 {
    public static void main(String[] args) {

//        System.out.println(sum(new int[]{2, 4, 6, 8, 10, 12, 14}));
//        System.out.println(factorial(5));
//        System.out.println(Arrays.toString(sort(new int[]{5, -6, 9, 12, 7})));
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

    // see on bubble sort
//        int temp = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                if (a[i] > a[j]) {      //swap elements if not in order
//                    temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//        //print sorted array
//        System.out.println("Array sorted in ascending order: ");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
//        return new int[0];


    // step by step bubble sort koos Siimuga
    // 5, -6, 9, 12, 7
//        for (int j = 0; j < a.length; j++) {
//            for (int i = 0; i < a.length - 1; i++) {
//                if (a[i] > a[i + 1]) {
//                    int tmp = a[i];
//                    a[i] = a[i + 1];
//                    a[i + 1] = tmp;
//                }
//            }
//        }
//        return a;

    // selection sort - kõige lähem sellele,
    // mis minu peas loogiline tundus
    // leiab esimese minimaalse ja jätab paika
    // seejärel võrdleb allejäänud arrayd
    // ja asetab järgmisele kohale suuruselt järgmise

    public static int sort(int[] a) {
    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    // 5, -6, 9, 12, 7

        return 0;
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


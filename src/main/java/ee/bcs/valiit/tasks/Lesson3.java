package ee.bcs.valiit.tasks;

public class Lesson3 {
    public static void main(String[] args) {

//        System.out.println(sum(new int[]{2, 4, 6, 8, 10, 12, 14}));
//        System.out.println(factorial(5));
//        System.out.println(Arrays.toString(sort(new int[]{5, -6, 9, 12, 7})));
//        System.out.println(reverseString("Your text here"));
//        System.out.println(isPrime(17));
    }

    public static int sumOfArray(int[] x) {
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

    public static int[] sort(int[] array) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
        // 5, -6, 9, 12, 7


        for (int j = 0; j < array.length - 1; j++) {
            int minIndex = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int tmp = array[j];
            array[j] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }


    public static String reverseString(String sõnad) {
        // TODO tagasta string tagurpidi

        int stringiPikkus = sõnad.length();

        for (int i = stringiPikkus; i >= 0; i--) {


        }
        return "";
    }

    public static boolean isPrime(int number) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)

        // viimane variant, millest aru ka saan. toimib.
        if (number == 1) {
            System.out.println("1 ei ole algarv because of reasons.");
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println(number + " ei ole algarv.");
                return false;
            }

        }
        System.out.println(number + " on algarv.");
        return true;

    }
}

// esialgne omalooming... ei toimi...

//        System.out.println("Sisestatud arv on " + number);
//
//        int a = number % 1; // kui jagub täpselt on jääk 0, else jääk > 0
//        int b = number % number; // kui jagub täpselt on jääk 0, else jääk > 0
//        System.out.println("number/1 = " + a);
//        System.out.println("number/number " + b);
//
//        if (a == 0 && b == 0) {
//            System.out.println("See on primaararv.");
//            return true;
//        } else {
//            System.out.println("See ei ole primaararv.");
//            return false;
//        }

// TODO TRIAL DIVISION - ruutjuurega on mõeldud selleks,
// TODO et algoritmi efektiivsemaks teha.
// Täisarvu a teguriks ehk jagajaks nimetatakse
// matemaatikas iga täisarvu, mis jagub arvuga a
// Algarv on arv, mis jagub täpselt ainult 1 ja iseendaga

// netist võetud ja ülearu keeruline + ei toimi

//        System.out.println("Etteantud arv on " + number);
//        // number millega jagama hakkab
//        int i = 2;
//        // ruutjuur etteantud numbrist
//        // castib intiks, sest muidu on double
////        int rtJrNumbrist = (int) Math.ceil(Math.sqrt(number));
//        // while loop lõppeb
//        // kui i <= rtJrNumbrist
//        while (i < number) {
//            // increment i, et järgmisel ringil
//            // järgmist numbrit kontrollida
//            i++;
//            // EHK: kui ükski numbritest, mis jääb
//            // 2 ja numbri vahel leidub etteantud numbri tegur
//            // SIIS see number ei ole primaararv, sest ta jagub
//            // ka millegi muu kui 1 ja iseendaga...
//            if (number % i == 0) {
//                // false - ei ole prime
//                return false;
//            }
//        }
//        // If none of the numbers is a factor,
//        // then it is a prime number
//        // kui ükski numbritest 2 ja rtJrNumbri vahel
//        // EI leidu ühtki tegurit SIIS etteantud number
//        // ON primaararv, sest järelikult ta jagub
//        // AINULT 1 ja iseendaga!
//        return true;
//    }



package ee.bcs.valiit.tasks.audacity;

public class Massiiv {
    public static String findLongestName(String[] names) {
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

    public static int searchForMax(int[] numbers) {
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

    public static int searchForMin(int[] numbers) {
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

    public static double average(double[] numbers) {
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

package ee.bcs.valiit.tasks;

public class Audacity {

    public static void main(String[] args) {

//        System.out.println(findLongestName(new String[]{"Jack", "Paul", "Larry", "Mary"}));
//        System.out.println(searchForMax(new int[]{2, 4, 6, 8}));
//        System.out.println(searchForMin(new int[]{2, 4, 6, 8}));
//        System.out.println(average(new double[]{75, 73, 72, 80}));


    }

    private static String findLongestName(String[] names) {
        //TODO AUDACITY harjutus
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

    private static int searchForMax(int[] numbers) {
        // TODO AUDACITY harjutus
        // leiab massiivist suurima numbri ja tagastab selle
        int size = numbers.length;
        int max = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    private static int searchForMin(int[] numbers) {
        // TODO AUDACITY harjutus
        // leiab massiivist väikseima numbri ja tagastab selle
        // ainuke erinevus eelmisega on < märk
        int size = numbers.length;
        int min = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    private static double average(double[] numbers) {
        // TODO AUDACITY harjutus
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

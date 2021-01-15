package ee.bcs.valiit.tasks;

public class Lesson1 {

    public static void main(String[] args) {
//        excersie1();
//        excersie2();
//        excersie3();
//        excersie4();
    }

    // TODO
    // defineeri 3 muutujat a = 1, b = 1, c = 3
    // Prindi välja a==b ja a==c
    // Lisa rida a = c
    // Prindi välja a==b ja a==c, mis muutus???
    public static void excersie1() {

        int a = 1;
        int b = 1;
        int c = 3;
        System.out.println(a == b); // 1 == 1 true
        System.out.println(a == c); // 1 == 3 false
        a = c; //omistab a'le c väärtuse. a = 3
        System.out.println(a == b); // 3 == 1 false
        System.out.println(a == c); // 3 == 3 true
    }

    // TODO
    // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
    // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
    // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
    // Analüüsi tulemusi

    // ++x is called preincrement while x++ is called postincrement

    // ++x increments the value of x and then returns x
    // x++ returns the value of x and then increments

    /*näide:
    int x = 5, y = 5;

System.out.println(++x); // outputs 6 sest increment ja siis return
System.out.println(x); // outputs 6

System.out.println(y++); // outputs 5 sest return (seda väärtust näitab) ja siis incrementib
System.out.println(y); // outputs 6 sest siin real on uus väärtus juba omistatud
*/
    public static void excersie2() {
//        int x1 = 10;
//        int x2 = 20;
//        int y1 = ++x1; // ++x increments the value of x and then returns x
//        // seega x1 = 11 ja omistab selle väärtuse y1'le
//        System.out.println("x1 = " + x1); // x1 uus väärtus 11
//        System.out.println("y1 = " + y1); // y1 uus väärtus 11
//        int y2 = x2++; // x++ returns the value of x and then increments
//        // kõigepealt omistab y2 väärtuse 20 ja alles seejärel incrementib x2
//        // seega returnib x2 value 20 ja siis incrementib,
//        // aga omistatakse returnitud value, sest see tuli ennem??? - õige
//        System.out.println("x2 = " + x2); // x2 uus väärtus 21
//        System.out.println("y2 = " + y2); // y2 väärtus jääb 20 sest omistati returnitud mitte incrementitud value
    }

    // TODO
    // Loo arvulised muutujad
    // a = 18 % 3
    // b = 19 % 3
    // c = 20 % 3
    // d = 21 % 3
    // Prindi välja kõigi muutujate väärtused
    public static void excersie3() {
        int a = 18 % 3; // 18/3=6 jagub kolmega täpselt, jääk 0
        int b = 19 % 3; // 19/3=6.3(3), ei jagu täpselt, jääk 1
        int c = 20 % 3; // 20/3=6.6(7), ei jagu täpselt, jääk 2
        int d = 21 % 3; // 21/3=7 jagub täpselt, jääk 0
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println(a + " " + b + " " + c + " " + d);

    }

    // TODO
    // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
    // Trüki muutuja sisu välja
    public static void excersie4() {

        String kribuKrabu = "\"\\\"\\\\\"\"";
//         miks "\"\\"" copy-pastega stringis teistmoodi välja näeb?
//         jutumärgid tuleb varjestada \ kaldkriipsuga, nimet escapeimiseks
         String name = "\"Siim\"";
//         \n on uus rida
        System.out.println(kribuKrabu);

    }
}

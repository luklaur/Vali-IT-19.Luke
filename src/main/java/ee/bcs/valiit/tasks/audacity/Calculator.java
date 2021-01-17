package ee.bcs.valiit.tasks.audacity;

// Since both add and subtract don't need any object-specific values,
// they can be declared static as seen below and hence you can call
// them directly using the class name Calculator without
// the need to create an object variable at all:


public class Calculator {
    public static int liida(int a, int b) {
        return a + b;
    }

    public static int lahuta(int a, int b) {
        return a - b;
    }

    public static int korruta(int a, int b) {
        return a * b;
    }

    public static double jaga(double a, double b) {
        return a / b;
    }
}

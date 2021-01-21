package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RandomGame {

    Random random = new Random();
    int randomNumber = random.nextInt(100);
    Scanner scanner = new Scanner(System.in);
    int guess = scanner.nextInt();

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}





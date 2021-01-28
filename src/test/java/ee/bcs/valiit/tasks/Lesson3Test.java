package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Lesson3Test {

    @Test
    void sumOfArray() {

        assertEquals(56, Lesson3.sumOfArray(new int[]{2, 4, 6, 8, 10, 12, 14}));
        assertEquals(26, Lesson3.sumOfArray(new int[]{5, 9, 6, 1, 5}));
    }

    @Test
    void factorial() {
    }

    @Test
    void sort() {
    }

    @Test
    void reverseString() {
    }

    @Test
    void isPrime() {
    }
}
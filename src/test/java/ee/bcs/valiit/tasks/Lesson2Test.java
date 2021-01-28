package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Lesson2Test {

    @Test
    void exercise1() {
    }

    @Test
    void exercise2() {
        List<Integer> expectedResult = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> actualResult = Lesson2.exercise2(5);
        // kui actualResult == expectedResult siis true
        assertTrue(actualResult.equals(expectedResult));

    }

    @Test
    void exercise3() {
    }

    @Test
    void exercise4() {
    }

    @Test
    void exercise5() {
    }

    @Test
    void muutujaLength() {

    }
}
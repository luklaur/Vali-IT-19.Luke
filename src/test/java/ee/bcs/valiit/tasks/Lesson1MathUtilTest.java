package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson1MathUtilTest {

    @Test
    void minOf2() {
        assertEquals(5, Lesson1MathUtil.minOf2(5, 17));
        assertEquals(3, Lesson1MathUtil.minOf2(8, 3));
    }

    @Test
    void maxOf2() {
        assertEquals(8, Lesson1MathUtil.maxOf2(5, 8));
        assertEquals(8, Lesson1MathUtil.maxOf2(8, 5));

        double expected = 5;
        double result = 5;
        assertEquals(expected, result, 0.00001);
    }

    @Test
    void abs() {
        assertEquals(5, Lesson1MathUtil.abs(-5));
        assertEquals(7, Lesson1MathUtil.abs(7));
    }

    @Test
    void isEven() {
        assertFalse(Lesson1MathUtil.isEven(5));
        assertTrue(Lesson1MathUtil.isEven(8));
    }

    @Test
    void minOf3() {
        assertEquals(4, Lesson1MathUtil.minOf3(4, 4, 5));
        assertEquals(5, Lesson1MathUtil.minOf3(5, 8, 16));
    }

    @Test
    void maxOf3() {
        assertEquals(5, Lesson1MathUtil.maxOf3(5, 5, 4));
        assertEquals(58, Lesson1MathUtil.maxOf3(58, 16, 25));

    }
}
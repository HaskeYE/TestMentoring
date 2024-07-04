package lesson3;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import static org.testng.AssertJUnit.*;

public class LoopsTest {

    @Test
    @Tag(name = "Example")
    public final void factorial() {
        assertEquals(1.0, Loops.factorial(0), 1.0E-5);
        assertEquals(1.0, Loops.factorial(1), 1.0E-5);
        assertEquals(6.0, Loops.factorial(3), 1.0E-5);
        assertEquals(120.0, Loops.factorial(5), 1.0E-5);
        assertEquals(3628800.0, Loops.factorial(10), 1.0E-5);
        assertEquals(2.43290200817664E18, Loops.factorial(20), 1.0E10);
    }

    @Test
    @Tag(name = "Example")
    public final void isPrime() {
        assertFalse(Loops.isPrime(1));
        assertTrue(Loops.isPrime(2));
        assertTrue(Loops.isPrime(5));
        assertTrue(Loops.isPrime(11));
        assertFalse(Loops.isPrime(4));
        assertFalse(Loops.isPrime(9));
        assertFalse(Loops.isPrime(15));
        int count = 0;
        for (int n = 2; n <= 7919; n++) {
            if (Loops.isPrime(n)) {
                count++;
            }
        }
        assertEquals(1000, count);
        for (int n = 2; n <= 1000000; n++) {
            if (Loops.isPrime(n)) {
                count++;
            }
        }
        assertEquals(79498, count);
    }

    @Test
    @Tag(name = "Example")
    public final void isPerfect() {
        assertTrue(Loops.isPerfect(6));
        assertTrue(Loops.isPerfect(28));
        assertFalse(Loops.isPerfect(100));
    }

    @Test
    @Tag(name = "Example")
    public final void digitCountInNumber() {
        assertEquals(1, Loops.digitCountInNumber(0, 0));
        assertEquals(1, Loops.digitCountInNumber(7, 7));
        assertEquals(0, Loops.digitCountInNumber(21, 3));
        assertEquals(1, Loops.digitCountInNumber(510, 5));
        assertEquals(3, Loops.digitCountInNumber(4784041, 4));
        assertEquals(4, Loops.digitCountInNumber(5373393, 3));
    }

    @Test
    @Tag(name = "Trivial")
    public final void digitNumber() {
        assertEquals(1, Loops.digitNumber(0));
        assertEquals(1, Loops.digitNumber(7));
        assertEquals(2, Loops.digitNumber(10));
        assertEquals(2, Loops.digitNumber(99));
        assertEquals(3, Loops.digitNumber(123));
        assertEquals(10, Loops.digitNumber(Integer.MAX_VALUE));
    }

    @Test
    @Tag(name = "Easy")
    public final void fib() {
        assertEquals(0, Loops.fib(0));
        assertEquals(1, Loops.fib(1));
        assertEquals(1, Loops.fib(2));
        assertEquals(2, Loops.fib(3));
        assertEquals(5, Loops.fib(5));
        assertEquals(21, Loops.fib(8));
        assertEquals(102334155, Loops.fib(40));
        assertEquals(1134903170, Loops.fib(45));
        assertEquals(1836311903, Loops.fib(46));
        Loops.fib(50);
    }

    @Test
    @Tag(name = "Easy")
    public final void fibiter() {
        assertEquals(0, Loops.fib(0));
        assertEquals(1, Loops.fib(1));
        assertEquals(1, Loops.fib(2));
        assertEquals(2, Loops.fib(3));
        assertEquals(5, Loops.fib(5));
        assertEquals(21, Loops.fib(8));
        assertEquals(102334155, Loops.fib(40));
        assertEquals(1134903170, Loops.fib(45));
        assertEquals(1836311903, Loops.fib(46));
        Loops.fib(50);
    }

    @Test
    @Tag(name = "Easy")
    public final void lcm() {
        assertEquals(13, Loops.lcm(13, 13));
        assertEquals(8, Loops.lcm(2, 8));
        assertEquals(24, Loops.lcm(6, 8));
        assertEquals(975, Loops.lcm(39, 75));
        assertEquals(13384091, Loops.lcm(1357, 9863));
        assertEquals(1339310349, Loops.lcm(13579, 98631));
        assertEquals(2089830349, Loops.lcm(23579, 88631));
        assertEquals(2022222222, Loops.lcm(2, 1011111111));
        assertEquals(2022222222, Loops.lcm(1011111111, 2));
    }

    @Test
    @Tag(name = "Easy")
    public final void minDivisor() {
        assertEquals(2, Loops.minDivisor(2));
        assertEquals(3, Loops.minDivisor(75));
        assertEquals(5, Loops.minDivisor(25));
        assertEquals(97, Loops.minDivisor(97));
        assertEquals(7, Loops.minDivisor(49));
        assertEquals(17, Loops.minDivisor(8653));
        assertEquals(2124679, Loops.minDivisor(2124679));
        assertEquals(1073676287, Loops.minDivisor(1073676287));
        assertEquals(Integer.MAX_VALUE, Loops.minDivisor(Integer.MAX_VALUE));
    }

    @Test
    @Tag(name = "Easy")
    public final void maxDivisor() {
        assertEquals(1, Loops.maxDivisor(17));
        assertEquals(12, Loops.maxDivisor(24));
        assertEquals(59, Loops.maxDivisor(177));
        assertEquals(17, Loops.maxDivisor(34));
        assertEquals(7, Loops.maxDivisor(49));
        assertEquals(509, Loops.maxDivisor(8653));
        assertEquals(1, Loops.maxDivisor(2124679));
        assertEquals(1, Loops.maxDivisor(1073676287));
        assertEquals(1, Loops.maxDivisor(Integer.MAX_VALUE));
    }

    @Test
    @Tag(name = "Easy")
    public final void isCoPrime() {
        assertFalse(Loops.isCoPrime(25, 50));
        assertTrue(Loops.isCoPrime(25, 49));
        assertFalse(Loops.isCoPrime(6, 8));
        assertTrue(Loops.isCoPrime(17, 97));
        assertFalse(Loops.isCoPrime(37, 111));
        assertFalse(Loops.isCoPrime(37, 37));
        assertFalse(Loops.isCoPrime(37, 74));
        assertTrue(Loops.isCoPrime(1234567890, 908765431));
        assertTrue(Loops.isCoPrime(2109876543, 1234567891));
    }

    @Test
    @Tag(name = "Easy")
    public final void squareBetweenExists() {
        assertTrue(Loops.squareBetweenExists(1, 1));
        assertTrue(Loops.squareBetweenExists(21, 28));
        assertTrue(Loops.squareBetweenExists(36, 48));
        assertTrue(Loops.squareBetweenExists(50, 64));
        assertFalse(Loops.squareBetweenExists(51, 61));
        assertFalse(Loops.squareBetweenExists(999, 1001));
        assertTrue(Loops.squareBetweenExists(152374337, 152423715));
        assertFalse(Loops.squareBetweenExists(2147395601, Integer.MAX_VALUE));
    }

    @Test
    @Tag(name = "Normal")
    public final void collatzSteps() {
        assertEquals(0, Loops.collatzSteps(1));
        assertEquals(1, Loops.collatzSteps(2));
        assertEquals(7, Loops.collatzSteps(3));
        assertEquals(5, Loops.collatzSteps(5));
        assertEquals(6, Loops.collatzSteps(10));
        assertEquals(7, Loops.collatzSteps(20));
        assertEquals(6, Loops.collatzSteps(64));
        assertEquals(25, Loops.collatzSteps(100));
        assertEquals(7, Loops.collatzSteps(128));
        assertEquals(111, Loops.collatzSteps(1000));
        assertEquals(128, Loops.collatzSteps(100000));
    }

    @Test
    @Tag(name = "Normal")
    public final void sin() {
        assertEquals(0.0, Loops.sin(0.0, 1.0E-5), 1.0E-5);
        assertEquals(1.0, Loops.sin(1.5707963267948966, 1.0E-5), 1.0E-5);
        assertEquals(0.0, Loops.sin(Math.PI, 1.0E-5), 1.0E-5);
        assertEquals(-1.0, Loops.sin(4.71238898038469, 1.0E-5), 1.0E-5);
//        assertEquals(0.0, Loops.sin(314.1592653589793, 1.0E-5), 1.0E-5);
    }

    @Test
    @Tag(name = "Normal")
    public final void cos() {
        assertEquals(1.0, Loops.cos(0.0, 1.0E-5), 1.0E-5);
        assertEquals(0.0, Loops.cos(1.5707963267948966, 1.0E-5), 1.0E-5);
        assertEquals(-1.0, Loops.cos(Math.PI, 1.0E-5), 1.0E-5);
        assertEquals(0.0, Loops.cos(4.71238898038469, 1.0E-5), 1.0E-5);
//        assertEquals(1.0, Loops.cos(314.1592653589793, 1.0E-5), 1.0E-5);
    }

    @Test
    @Tag(name = "Normal")
    public final void revert() {
        assertEquals(87431, Loops.revert(13478));
        assertEquals(0, Loops.revert(0));
        assertEquals(3, Loops.revert(3));
        assertEquals(111, Loops.revert(111));
        assertEquals(17571, Loops.revert(17571));
        assertEquals(123456789, Loops.revert(987654321));
    }

    @Test
    @Tag(name = "Normal")
    public final void isPalindrome() {
        assertTrue(Loops.isPalindrome(3));
        assertFalse(Loops.isPalindrome(3653));
        assertTrue(Loops.isPalindrome(15751));
        assertTrue(Loops.isPalindrome(24688642));
    }

    @Test
    @Tag(name = "Normal")
    public final void hasDifferentDigits() {
        assertTrue(Loops.hasDifferentDigits(323));
        assertTrue(Loops.hasDifferentDigits(54));
        assertTrue(Loops.hasDifferentDigits(222266666));
        assertFalse(Loops.hasDifferentDigits(0));
        assertFalse(Loops.hasDifferentDigits(777));
    }

    @Test
    @Tag(name = "Hard")
    public final void squareSequenceDigit() {
        assertEquals(1, Loops.squareSequenceDigit(1));
        assertEquals(4, Loops.squareSequenceDigit(2));
        assertEquals(5, Loops.squareSequenceDigit(7));
        assertEquals(6, Loops.squareSequenceDigit(12));
        assertEquals(0, Loops.squareSequenceDigit(17));
        assertEquals(9, Loops.squareSequenceDigit(27));
    }

    @Test
    @Tag(name = "Hard")
    public final void fibSequenceDigit() {
        assertEquals(1, Loops.fibSequenceDigit(1));
        assertEquals(1, Loops.fibSequenceDigit(2));
        assertEquals(3, Loops.fibSequenceDigit(4));
        assertEquals(2, Loops.fibSequenceDigit(9));
        assertEquals(5, Loops.fibSequenceDigit(14));
        assertEquals(2, Loops.fibSequenceDigit(20));
    }
}

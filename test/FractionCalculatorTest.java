import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FractionCalculatorTest {

    @Test
    void isValidOperation() {
    }

    @Test
    void invalidFractionReturnsFalse() {
        // === given/when ===
        String s1 = "three";
        String s2 = "two/three";
        String s3 = "3/two";
        String s4 = "1 / 2";
        String s5 = "0.5";
        String s6 = ".";
        String s7 = "-";
        String s8 = "2/-1";
        // === then ===
        assertEquals(false, FractionCalculator.isValidFraction(s1), s1 + " is not a valid fraction");
        assertEquals(false, FractionCalculator.isValidFraction(s2), s2 + " is not a valid fraction");
        assertEquals(false, FractionCalculator.isValidFraction(s3), s3 + " is not a valid fraction");
        assertEquals(false, FractionCalculator.isValidFraction(s4), s4 + " is not a valid fraction");
        assertEquals(false, FractionCalculator.isValidFraction(s5), s5 + " is not a valid fraction");
        assertEquals(false, FractionCalculator.isValidFraction(s6), s6 + " is not a valid fraction");
        assertEquals(false, FractionCalculator.isValidFraction(s7), s7 + " is not a valid fraction");
        assertEquals(false, FractionCalculator.isValidFraction(s8), s8 + " is not a valid fraction");

    }

    @Test
    void validFractionReturnsTrue() {
        // === given/when ===
        String s1 = "1";
        String s2 = "-1";
        String s3 = "1/2";
        assertEquals(true, FractionCalculator.isValidFraction(s1));
        assertEquals(true, FractionCalculator.isValidFraction(s2));
        assertEquals(true,FractionCalculator.isValidFraction(s3));
    }

    @Test
    void getFraction() {
        // === given/when ===
        Scanner sc = new Scanner("1/2");
        Fraction expectedFraction = new Fraction(1,2);
        // === then ===
        assertEquals(expectedFraction, FractionCalculator.getFraction(sc), "Fractions are not equal");
    }
}
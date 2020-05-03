import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FractionCalculatorAdvancedTest {

    @Test
    void isValidOneLinerReturnsTrue() {
        // === given/when ===
        String s1 = "45 / 22";
        String s2 = "33 / 11";
        String s3 = "1/2 * 4/3";
        String s4 = "-11/14 / -7/11";
        String s5 = "Q";
        String s6 = "1 * 2";

        // === then ===
        assertEquals(true, FractionCalculatorAdvanced.isValidOneLiner(s1),s1 + " is a valid fraction");
        assertEquals(true, FractionCalculatorAdvanced.isValidOneLiner(s2),s2 + " is a valid fraction");
        assertEquals(true, FractionCalculatorAdvanced.isValidOneLiner(s3),s3 + " is a valid fraction");
        assertEquals(true, FractionCalculatorAdvanced.isValidOneLiner(s4),s4 + " is a valid fraction");
        assertEquals(true, FractionCalculatorAdvanced.isValidOneLiner(s5),s5 + " is a valid fraction");
        assertEquals(true, FractionCalculatorAdvanced.isValidOneLiner(s6),s6 + " is a valid fraction");
    }

    @Test
    void isValidOneLinerReturnsFalse() {
        // === given/when ===
        String s1 = "three";
        String s2 = "two/three";
        String s3 = "3/two";
        String s4 = "1 / 2";
        String s5 = "0.5";
        String s6 = ".";
        String s7 = "-";
        String s8 = "2/-1";
        String s9 = "this";
        String s10 = "2 + foo";
        // === then ===
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s1), s1 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s2), s2 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s3), s3 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s4), s4 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s5), s5 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s6), s6 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s7), s7 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s8), s8 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s9), s9 + " is not a valid fraction");
        assertEquals(false, FractionCalculatorAdvanced.isValidOneLiner(s10), s10 + " is not a valid fraction");

    }
}
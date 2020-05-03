import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction simplifiedFrac;
    private Fraction complexFrac;
    private Fraction negativeFraction;

    @BeforeEach
    void setUp() {
        simplifiedFrac = new Fraction(1,2);
        complexFrac = new Fraction(50, 100);
        negativeFraction = new Fraction (-1,3);
    }

    @Test
    void testToString() {
        assertEquals("1/2", simplifiedFrac.toString(), "Fraction should print as '1/2'");
        assertEquals("-1/3", negativeFraction.toString(), "Fraction should print as '-1/3'");
    }

    @Test
    void toDouble() {
        assertEquals(0.5, simplifiedFrac.toDouble(), "Double should equal 0.5 not " + simplifiedFrac.toDouble());
    }

    @Test
    void add() {
        assertEquals("1/1", simplifiedFrac.add(complexFrac).toString(),"Result should be '1/1', not '" + simplifiedFrac.add(complexFrac).toString() + "'");
        assertEquals("1/6", simplifiedFrac.add(negativeFraction).toString(),"Result should be '1/6', not '" + simplifiedFrac.add(negativeFraction).toString() + "'");
    }

    @Test
    void subtract() {
        assertEquals("0/1", simplifiedFrac.subtract(complexFrac).toString(),"Result should be '0/1', not '" + simplifiedFrac.subtract(complexFrac).toString() + "'");
        assertEquals("5/6", simplifiedFrac.subtract(negativeFraction).toString(), "Result should be '1/6', not '" + simplifiedFrac.subtract(negativeFraction).toString() + ";");
    }

    @Test
    void multiply() {
        // === given/when ===
        Fraction frac1 = new Fraction(4,7);
        Fraction frac2 = new Fraction(3,11);
        Fraction result1 = frac1.multiply(frac2);
        Fraction frac3 = new Fraction(-3,2);
        Fraction frac4 = new Fraction(5,4);
        Fraction result2 = frac3.multiply(frac4);
        // === then ===
        assertEquals(12.0/77, result1.toDouble());
        assertEquals(-15.0/8, result2.toDouble());
    }

    @Test
    void divide() {
        // === given/when ===
        Fraction frac1 = new Fraction(2, 7);
        Fraction frac2 = new Fraction(3,8);
        Fraction result = frac1.divide(frac2);
        // === then ===
        assertEquals(16.0/21, result.toDouble());
    }


    @Test
    void testEquals() {
        assertEquals(true, simplifiedFrac.equals(complexFrac), "Fractions should be equal");
    }

    @Test
    void toLowestTerms() {
        // === given ===
        complexFrac.toLowestTerms();
        // === then ===
        assertEquals("1/2", complexFrac.toString(), "Fraction should be simplified to 1/2, not " + complexFrac.toString());
    }

    @Test
    void gcd() {
    }
}
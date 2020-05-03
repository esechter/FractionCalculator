public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction (int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be zero");
        }
        if (denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction (int parameter) {
        this(parameter, 1);
    }

    public Fraction () {
        this(0,1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public double toDouble() {
        return ((double) numerator) / denominator;
    }

    public Fraction add(Fraction other) {
        Fraction result = null;
        if (this.denominator == other.denominator) {
            result = new Fraction(this.numerator + other.numerator, this.denominator);
        } else {
            Fraction complexThis = multiply(new Fraction(other.denominator, other.denominator));
            Fraction complexOther = other.multiply(new Fraction(this.denominator, this.denominator));
            result = complexThis.add(complexOther);
            result.toLowestTerms();
        }
        return result;
    }
    //TODO
    public Fraction subtract(Fraction other) {
        Fraction result = null;
        if (this.denominator == other.denominator) {
            result = new Fraction(this.numerator - other.numerator, this.denominator);
        } else {
            Fraction complexThis = multiply(new Fraction(other.denominator, other.denominator));
            Fraction complexOther = other.multiply(new Fraction(this.denominator, this.denominator));
            result = complexThis.subtract(complexOther);
            result.toLowestTerms();
        }
        return result;
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        return multiply(new Fraction(other.denominator, other.numerator));
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction otherFraction = (Fraction) other;
            Fraction simplifiedThis = new Fraction(this.numerator, this.denominator);
            simplifiedThis.toLowestTerms();
            Fraction simplifiedOther = new Fraction(otherFraction.numerator, otherFraction.denominator);
            simplifiedOther.toLowestTerms();
            if (simplifiedThis.numerator == simplifiedOther.numerator) {
                return (simplifiedOther.denominator == simplifiedThis.denominator);
            }
        }
        return false;
    }

    public void toLowestTerms() {
        if (this.numerator == 0 && this.denominator != 0) {
            this.denominator = 1;
        } else {
            int gcd = gcd(this.numerator, this.denominator);
            this.numerator = this.numerator / gcd;
            this.denominator = this.denominator / gcd;
        }
    }

    public int gcd (int num, int den) {
        while (num != 0 && den != 0) {
            int remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }
}

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
}

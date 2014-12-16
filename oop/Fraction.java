public class Fraction {

    private int numerator;
    private int denominator;


    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public Fraction(String str) {
        int iSlash = str.indexOf("/");
        numerator = Integer.parseInt(str.substring(0, iSlash));
        denominator = Integer.parseInt(str.substring(iSlash + 1));
    }

    public Fraction(Fraction copyFrom) {
        this(copyFrom.numerator, copyFrom.denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double)numerator / denominator;
    }

    private int gcf(int a, int b) {
        while(a != b) {
            if(a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    public Fraction reduce() {
        int gcf = gcf(numerator, denominator);
        numerator /= gcf;
        denominator /= gcf;
        return this;
    }

    public Fraction negate() {
        return new Fraction(numerator * -1, denominator);
    }

    public Fraction recip() {
        return new Fraction(denominator, numerator);
    }

    public static Fraction product(Fraction... multiplicands) {
        Fraction out = new Fraction();  // multiplicative identity
        for(Fraction frac : multiplicands) {
            out.numerator *= frac.numerator;
            out.denominator *= frac.denominator;
        }
        return out.reduce();
    }

    public static Fraction quotient(Fraction divisor, Fraction dividend) {
        return product(divsor, dividend.recip());
    }

    public static Fraction sum(Fraction... addends) {
        Fraction out = new Fraction(0, 1);  // additive identity
        for(Fraction frac : addends) {
            int lcd = out.denominator * frac.denominator / gcf(out.denominaotr, frac.denominator);
            int numerator = out.numerator * (lcd / out.denominator) + frac.numerator * (lcd / frac.demoninator);
            out = new Fraction(numerator, lcd);
        }
        return out.reduce();
    }

    public static Fraction difference(Fraction subtractor, Fraction subtractent) {
        return sum(subtractor, subtractant.negate());
    }
}

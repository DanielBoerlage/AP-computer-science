package oop;

public class Fraction {

//############################################################################  FIELDS

    private int numerator;
    private int denominator;
    private boolean sign;


//############################################################################  CONSTRUCTORS

    public Fraction(int numerator, int denominator) {
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
        sign = numerator * denominator > 0;
    }

    public Fraction() {
        this(1, 1);
    }

    public Fraction(String str) {
        int iSlash = str.indexOf("/");
        this(Integer.parseInt(str.substring(0, iSlash)), Integer.parseInt(str.substring(iSlash + 1)));
    }

    public Fraction(Fraction copyFrom) {
        this(copyFrom.numerator, copyFrom.denominator);
    }


//############################################################################  GETTERS

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public boolean isPositive() {
        return sign;
    }

    public String toString() {
        return (sign ? "" : "-") + numerator + "/" + denominator;
    }

    public double toDouble() {
        return ((sign ? 1.0 : -1.0) * numerator) / denominator;
    }


//############################################################################  MODIFIERS

    public Fraction reduce() {
        int gcf = gcf(numerator, denominator);
        numerator /= gcf;
        denominator /= gcf;
        return this;
    }

//############################################################################  NON-MODIFING MATHS


    public Fraction negate() {
        return new Fraction(numerator * -1, denominator);
    }

    public Fraction recip() {
        return new Fraction(denominator, numerator);
    }


//############################################################################  STATIC MATHS

    public static Fraction product(Fraction... multiplicands) {
        Fraction out = new Fraction(1, 1);  // multiplicative identity
        for(Fraction frac : multiplicands) {
            out.numerator *= frac.numerator;
            out.denominator *= frac.denominator;
            out.sign = 
        }
        return out.simplify();
    }

    public static Fraction quotient(Fraction divisor, Fraction dividend) {
        return product(divisor, dividend.recip());
    }

    public static Fraction sum(Fraction... addends) {
        Fraction out = new Fraction(0, 1);  // additive identity
        for(Fraction frac : addends) {
            int lcd = out.denominator * frac.denominator / gcf(out.denominator, frac.denominator);
            int numerator = out.numerator * (lcd / out.denominator) + frac.numerator * (lcd / frac.denominator);
            out = new Fraction(numerator, lcd);
        }
        return out.simplify();
    }

    public static Fraction difference(Fraction subtractor, Fraction subtractent) {
        return sum(subtractor, subtractent.negate());
    }

//############################################################################  UTILS

    private static int gcf(int a, int b) {
        while(a != b) {
            if(a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }
}

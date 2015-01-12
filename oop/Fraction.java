package oop;

public class Fraction {

    private int num;
    private int den;


    public Fraction(int num, int den) {
        if(den < 0) {
            num *= -1;
            den *= -1;
        }
        this.num = num;
        this.den = den;
    }

    public Fraction(String str) throws NumberFormatException {
        int iSlash = str.indexOf("/");
        if(iSlash < 0) {
            num = Integer.parseInt(str);
            den = 1;
        } else {
            num = Integer.parseInt(str.substring(0, iSlash));
            den = Integer.parseInt(str.substring(iSlash + 1));
        }
    }

    public Fraction() {
        this(1, 1);
    }

    public Fraction(Fraction copyFrom) {
        this(copyFrom.num, copyFrom.den);
    }

    public int getNumerator() {
        return Math.abs(num);
    }

    public int getDenominator() {
        return den;
    }

    public String toString() {
        if(den == 1)
            return String.valueOf(num);
        return num + "/" + den;
    }

    public double toDouble() {
        return (double)num / den;
    }

    private static int gcf(int a, int b) {
        a = Math.abs(a);
        while(a != b) {
            if(a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    public Fraction reduce() {
        if(num == 0)
            return new Fraction(0, 1);
        if(den == 0)
            return new Fraction(1, 0);
        int gcf = gcf(num, den);
        num /= gcf;
        den /= gcf;
        return this;
    }

    public Fraction negate() {
        return new Fraction(num * -1, den);
    }

    public Fraction recip() {
        return new Fraction(den, num);
    }

    public static boolean equals(Fraction a, Fraction b) {
        return minus(a, b).num == 0;
    }

    public static Fraction mult(Fraction... fs) {
        Fraction out = new Fraction(1, 1);  // multiplicative identity
        for(Fraction f : fs) {
            out.num *= f.num;
            out.den *= f.den;
        }
        return out.reduce();
    }

    public static Fraction divide(Fraction a, Fraction b) {
        return mult(a, b.recip());
    }

    public static Fraction plus(Fraction... fs) {
        Fraction out = new Fraction(0, 1);  // additive identity
        for(Fraction f : fs) {
            int lcd = out.den * f.den / gcf(out.den, f.den);
            int num = out.num * (lcd / out.den) + f.num * (lcd / f.den);
            out = new Fraction(num, lcd);
        }
        return out.reduce();
    }

    public static Fraction minus(Fraction a, Fraction b) {
        return plus(a, b.negate());
    }
}

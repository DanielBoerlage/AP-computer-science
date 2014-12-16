package oop;

public class Main {

    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 4);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();
        System.out.println("a*b = " + Fraction.product(a, b));
        System.out.println("a/b = " + Fraction.quotient(a, b));
        System.out.println("a+b = " + Fraction.sum(a, b));
        System.out.println("a-b = " + Fraction.difference(a, b));
    }
}

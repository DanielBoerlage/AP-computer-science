package oop;

import java.util.Scanner;

public class Main {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("Fraction quiz\n");

        Fraction a = Fraction.randomPositiveInteger(5);
        Fraction b = Fraction.randomPositiveInteger(5);
        test(Fraction.plus(a, b), getInput("1:  " + a + " + " + b + " = "));

        a = Fraction.randomSignedInteger(20);
        b = Fraction.randomSignedInteger(20);
        if(b.isPositive())
            test(Fraction.plus(a, b), getInput("2:  " + a + " + " + b + " = "));
        else
            test(Fraction.plus(a, b), getInput("2:  " + a + " - " + b.negate() + " = "));

        a = Fraction.randomPositiveInteger(5);
        b = Fraction.randomPositiveFraction(4, 4).reduce();
        test(Fraction.plus(a, b), getInput("3:  " + a + " + " + b + " = "));


        a = Fraction.randomSignedInteger(10);
        b = Fraction.randomSignedFraction(6, 6).reduce();
        if(b.isPositive())
            test(Fraction.plus(a, b), getInput("4:  " + a + " + " + b + " = "));
        else
            test(Fraction.plus(a, b), getInput("4:  " + a + " - " + b.negate() + " = "));



        a = Fraction.randomSignedFraction(10, 8);
        b = Fraction.randomSignedFraction(10, 8);
        if(b.isPositive())
            test(Fraction.plus(a, b), getInput("5:  " + a + " + " + b + " = "));
        else
            test(Fraction.plus(a, b), getInput("5:  " + a + " - " + b.negate() + " = "));


        a = Fraction.randomSignedInteger(10);
        b = Fraction.randomSignedFraction(10, 8);
        if(b.isPositive())
            test(Fraction.mult(a, b), getInput("6:  " + a + " * " + b + " = "));
        else
            test(Fraction.mult(a, b), getInput("6:  " + a + " * (-" + b.negate() + ") = "));



        a = Fraction.randomSignedFraction(15, 12);
        b = Fraction.randomSignedFraction(15, 12);
        if(b.isPositive())
            test(Fraction.divide(a, b), getInput("7:  " + a + " / " + b + " = "));
        else
            test(Fraction.divide(a, b), getInput("7:  " + a + " / (-" + b.negate() + ") = "));



        a = Fraction.randomSignedFraction(12, 9);
        b = Fraction.randomPositiveFraction(12, 9);
        Fraction c = Fraction.randomSignedFraction(8, 5);
        if(c.isPositive())
            test(Fraction.mult(a, b, c), getInput("8:  " + a + " * " + b + " * " + c + " = "));
        else
            test(Fraction.mult(a, b, c), getInput("8:  " + a + " * " + b + " * (-" + c.negate() + ") = "));

        a = Fraction.randomSignedFraction(12, 9);
        b = Fraction.randomPositiveFraction(10, 8);
        c = Fraction.randomSignedFraction(8, 4);
        if(c.isPositive())
            test(Fraction.plus(a, b, c), getInput("9:  " + a + " + " + b + " + " + c + " = "));
        else
            test(Fraction.plus(a, b, c), getInput("9:  " + a + " + " + b + c.negate() + " = "));

        a = Fraction.randomSignedFraction(12, 7);
        b = Fraction.randomPositiveFraction(10, 8);
        c = Fraction.randomPositiveFraction(8, 4);
        Fraction d = Fraction.randomSignedFraction(5, 3);
        if(c.isPositive())
            test(Fraction.plus(Fraction.mult(a, b), Fraction.mult(c, d)), getInput("10:  " + a + " * " + b + " + " + c + " * " + d + " = "));
        else
            test(Fraction.plus(Fraction.mult(a, b), Fraction.mult(c, d)), getInput("10:  " + a + " * " + b + " + " + c + " * (-" + c.negate() + ") = "));
    }

    private static void test(Fraction answer, Fraction input) {
        if(Fraction.equals(answer, input))
            System.out.println("Correct!\n");
        else {
            System.out.println("Incorrect!\nCorrect answer is: " + answer + "\n");
            System.exit(0);
        }
    }

    private static Fraction getInput(String prompt) {
        System.out.print(prompt);
        Fraction out;
        try {
            out = new Fraction(sc.next());
        } catch(NumberFormatException e) {
            System.out.println("Bad input.");
            return getInput(prompt);
        }
        return out;
    }
}

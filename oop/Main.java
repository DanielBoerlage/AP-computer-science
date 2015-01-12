package oop;

import java.util.Scanner;

public class Main {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Fraction a;
        Fraction b;

        Fraction answer = new Fraction();
        Fraction input = new Fraction();


        System.out.println("Fraction quiz\n");


        a = randomNumber(10);
        b = randomNumber(10);
        answer = Fraction.plus(a, b);
        input = getInput("1:  " + a + " + " + b + " = ");
        if(Fraction.equals(answer, input)) {
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect!\n");
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

    private static Fraction randomNumber(int max) {
        return new Fraction((int)(Math.random() * max) + 1, 1);
    }

    private static Fraction randomFraction(int maxDenom, int maxNum) {
        return new Fraction((int)(Math.random() * maxNum) + 1, (int)(Math.random() * maxDenom) + 1).reduce();
    }
}

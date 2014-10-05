package interest;

import java.util.Scanner;

public class InterestCalc {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("hint - you can leave any field blank to give it a default value");
		
		double initialInvestment = promptN("initial investment", 100.0);
		double annualRate = promptN("annual interest rate", .1);
		double nYears = promptN("number of years of investment", 10.0);
		double nCompounds = promptN("number of times the interest is compounded per year", 12.0);

		double totalMoney = initialInvestment * Math.pow(1.0 + annualRate / nCompounds, nYears * nCompounds);

		System.out.println("The final balance after " + nYears + " years is " + totalMoney);
	}

	private static double promptN(String n, double defaultN) {
		System.out.println("Enter the " + n);
		try {
			String input = sc.nextLine();
			if(input.length() == 0) {
				System.out.println(defaultN);
				return defaultN;
			}
			return Double.parseDouble(input);
		} catch(NumberFormatException e) {
			System.out.println("Invalid number");
			return promptN(n, defaultN);
		}
	}
}
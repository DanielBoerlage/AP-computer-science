package temperature;

import java.util.Scanner;

public class TemperatureCalc {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("The temperature in Celcius is " + (int)((promptTemp() - 32) * 5/9) + " degrees");
	}

	private static int promptTemp() {
		try {
			System.out.print("Enter a temperature in Fahrenheit: ");
			return new Integer(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Invalid integer");
			return promptTemp();
		}
	}
}
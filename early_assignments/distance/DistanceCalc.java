package distance;

import java.util.Scanner;

public class DistanceCalc {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the coordinates of the first point in n-dimensional space seperated by commas");
		double[] firstPoint = promptPosition();
		System.out.println("Now enter the coordinates of the second point");
		double[] secondPoint = promptPosition();
		if(firstPoint.length != secondPoint.length) {
			System.out.println("The two points given exist in a different number of dimensions!");
			main(null);
			return;
		}
		double sum = 0;
		for(int i = 0; i < firstPoint.length; i++)
			sum += Math.pow(firstPoint[i] - secondPoint[i], 2);
		System.out.println("The distance between the two points is " + Math.abs(Math.sqrt(sum)));
	}

	private static double[] promptPosition() {
		String[] imput = sc.nextLine().split(",");
		double[] values = new double[imput.length];
		for(int i = 0; i < values.length; i++) {
			try {
				values[i] = Double.parseDouble(imput[i].trim());
			} catch(NumberFormatException e) {
				System.out.println("Invalid number \"" + imput[i] + "\"");
				return promptPosition();
			}
		}
		return values;
	}
}
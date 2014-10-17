package box;

import java.util.Scanner;

class Box {

	Scanner s = new Scanner(System.in);

	private static final char topLeft = 218;
	private static final char bottomLeft = 192;
	private static final char topRight = 191;
	private static final char bottomRight = 217;
	private static final char verticalBar = 179;
	private static final char horizontalBar = 196;

	public static void main(String[] args) {
		int width = 0, height = 0;
		try {
			width = Integer.valueOf(args[0]);
			height = Integer.valueOf(args[1]);
		} catch(NumberFormatException e) {
			error("Invalid integer");
		} catch(ArrayIndexOutOfBoundsException e) {
			error("Enter 2 integers");
		}
		if(width <= 1 || height <= 1)
			error("Minimum box size is 2 by 2");
		box(width, height);
	}

	private static void error(String msg) {
		System.out.println(msg);
		System.exit(-1);
	}

	private static void box(int width, int height) {
		System.out.println(topLeft + nChars(horizontalBar, width - 2) + topRight);
		for(int i = 0; i < height - 2; i++)
			System.out.println(verticalBar + nChars(' ', width - 2) + verticalBar);
		System.out.println(bottomLeft + nChars(horizontalBar, width - 2) + bottomRight);
	}

	private static String nChars(char c, int n) {
		String out = "";
		for(int i = 0; i < n; i++)
			out += c;
		return out;
	}
}
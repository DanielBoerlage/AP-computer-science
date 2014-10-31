package chemical_words;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("hi");
		ArrayList<int[]> arr = new ArrayList<int[]>();
		arr.add(new int[2]);
		arr.get(0)[0] = 1;
		arr.get(0)[1] = 2;
		arr.add(new int[1]);
		arr.get(1)[0] = 3;
		System.out.println(arr.get(0)[0] + "  " + arr.get(0)[1] + "  " + arr.get(1)[0]);
	}
}
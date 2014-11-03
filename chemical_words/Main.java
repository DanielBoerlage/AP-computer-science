package chemical_words;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i < args.length; i++)
			System.out.println(StringProcessor.process(args[i]));
	}
}
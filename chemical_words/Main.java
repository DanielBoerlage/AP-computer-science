package chemical_words;

import java.util.ArrayList;
import java.io.File;

public class Main {

	public static void main(String[] args) {
		//for(int i = 0; i < args.length; i++)
		//	System.out.println(StringProcessor.process(args[i]));

		//for(Combinatorics.Combination combination : Combinatorics.getCombinations(3))
		//	System.out.println(combination);
		try {
			File src = new File("C:/Users/Daniel/Desktop/github/AP-computer-science/chemical_words/elements.tsv");
			ElementDict dict = new ElementDict(src);
			System.out.println(dict);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

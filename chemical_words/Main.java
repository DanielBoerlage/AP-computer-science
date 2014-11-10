package chemical_words;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) {
		//for(int i = 0; i < args.length; i++)
		//	System.out.println(StringProcessor.process(args[i]));

		//for(Combinatorics.Combination combination : Combinatorics.getCombinations(3))
		//	System.out.println(combination);
		try {
			File src = new File("C:/Users/Daniel/Desktop/github/AP-computer-science/chemical_words/elements.tsv");
			ElementDict dict = new ElementDict(src);
//			for(int i = 0; i < args.length; i++)
//				System.out.println(StringProcessor.process(args[i], dict));
			File words = new File("C:/Users/Daniel/Desktop/github/AP-computer-science/chemical_words/linux.words");
			BufferedReader reader = new BufferedReader(new FileReader(words));
			String word = null;
			int bestSize = 0;
			while((word = reader.readLine()) != null) {
				ElementWord elementWord = StringProcessor.process(word, dict);
				if(elementWord.exists() && word.length() > bestSize) {
					System.out.println(word + "\n" + elementWord + "\n");
					bestSize = word.length();
				}
				System.out.print(word);
				System.out.print("                                              \r");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package chemical_words;

import java.util.ArrayList;

public class StringProcessor {

	public static ElementWord process(String str, ElementDict dict) {
		ArrayList<Integer> doubles = new ArrayList<Integer>();
		for(int i = 0; i < str.length() - 1; i++) {
			if(dict.hasDouble(str.charAt(i), str.charAt(i+1)))
				doubles.add(i);
		}
		for(Combinatorics.Combination combination : Combinatorics.getCombinations(doubles.size())) {
			Element[] elements = new Element[str.length() - combination.getSum()];
			for(int strI = 0, elementI = 0; strI < str.length();) {
				if(doubles.contains(strI) && combination.getStateAt(doubles.indexOf(strI)) {
					elements[elementI] = dict.getElement(str.substring(strI, strI + 2));
					elementI++;
					strI+= 2;
				} else 
			}
		}
	}
}

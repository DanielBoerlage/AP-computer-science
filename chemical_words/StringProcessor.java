package chemical_words;

import java.util.ArrayList;

public class StringProcessor {

	public static ElementWord process(String str, ElementDict dict) {
		ArrayList<Integer> doubles = new ArrayList<Integer>();
		for(int i = 0; i < str.length() - 1; i++) {
			if(dict.hasDouble(str.charAt(i), str.charAt(i+1)))
				doubles.add(i);
		}
//		System.out.println(doubles);
		for(Combinatorics.Combination combination : Combinatorics.getCombinations(doubles.size())) {
			Element[] elements = new Element[str.length() - combination.getSum()];
			for(int strI = 0, elementI = 0; strI <= str.length(); elementI++) {
//				System.out.println(strI);
				if(strI >= str.length() || elementI >= elements.length) {
//					System.out.println("found word!");
					return new ElementWord(elements);

				}
				if(doubles.contains(strI) && combination.getStateAt(doubles.indexOf(strI))) {
					elements[elementI] = dict.getElement(str.substring(strI, strI + 2));
//					System.out.println(str.substring(strI, strI + 2) + "  " + dict.getElement(str.substring(strI, strI + 2)));
					strI+= 2;
//					System.out.println("double");
				} else if(dict.hasSingle(str.charAt(strI))) {
					elements[elementI] = dict.getElement(str.substring(strI, strI + 1));
					strI+= 1;
//					System.out.println("single");
				} else
					break;
			}
		}
		return new ElementWord();
	}
}

package chemical_words;

import java.util.ArrayList;

public class ElementWord {

	private ArrayList<Element> word;
	private boolean DNE;

	public ElementWord() {
		DNE = true;
	}

	public ElementWord(ArrayList<Element> word) {
		this.word = word;
		DNE = false;
	}

	public String toString() {
		if(DNE)
			return "Does not exist";
		String out = "";
		for(int i = 0; i < word.size(); i++)
			out += word.get(i).getSymbol();
		out += "\n";
		for(int i = 0; i < word.size(); i++)
			out += word.get(i).getName() + " ";
		return out;
	}
}
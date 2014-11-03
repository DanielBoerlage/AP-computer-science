package chemical_words;

import java.util.ArrayList;

public class ElementWord {

	private ArrayList<Element> word;

	public Element() {
		word = new ArrayList<Element>();
	}

	public Element(ArrayList<Element> word) {
		this.word = word;
	}

	public toString() {
		String out = "";
		for(int i = 0; i < word.size(); i++)
			out += word.get(i).getSymbol();
		out += "\n";
		for(int i = 0; i < word.size(); i++)
			out += word.get(i).getName() + " ";
		return out;
	}
}
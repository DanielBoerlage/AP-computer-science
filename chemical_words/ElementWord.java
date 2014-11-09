package chemical_words;

import java.util.ArrayList;

public class ElementWord {

	private Element[] word;
	private boolean DNE;

	public ElementWord() {
		DNE = true;
	}

	public ElementWord(Element[] copyFrom) {
		word = new Element[copyFrom.length];
		System.arraycopy(copyFrom, 0, word, 0, copyFrom.length);
		DNE = false;
	}

	public int length() {
		return word.length();
	}

	public int getElementAt(int i) {
		return word[i];
	}

	public String toString() {
		if(DNE)
			return "Does not exist";
		String out = "";
		for(int i = 0; i < word.length; i++)
			out += word[i].getSymbol();
		out += "\n";
		for(int i = 0; i < word.length; i++)
			out += word[i].getName() + " ";
		return out;
	}
}

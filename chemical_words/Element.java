package chemical_words;

public class Element {

	private final String symbol, name;

	public Element(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return symbol + " " + name;
	}
}

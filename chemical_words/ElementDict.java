package chemical_words;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ElementDict {

    private Element[] elements;

    public ElementDict(File srcFile) throws IOException, FileNotFoundException {
        ArrayList<Element> elementList = new ArrayList<Element>();
        BufferedReader reader = new BufferedReader(new FileReader(srcFile));
        String line = null;
        while((line = reader.readLine()) != null) {
            String[] elementDat = line.split("\\t");
            elementList.add(new Element(elementDat[0], elementDat[1]));
        }
        elements = new Element[0];
        elements = elementList.toArray(elements);
    }

    public Element getElement(String symbol) {
        for(Element element : elements) {
            if(element.getSymbol().equalsIgnoreCase(symbol))
                return element;
        }
        return null;
    }

    public boolean hasSingle(char c) {
        c = Character.toUpperCase(c);
        for(Element element : elements) {
            String symbol = element.getSymbol();
            if(symbol.length() == 1 && symbol.charAt(0) == c)
                return true;
        }
        return false;
    }

    public boolean hasDouble(char c, char cSucc) {
        c = Character.toUpperCase(c);
        cSucc = Character.toLowerCase(cSucc);
        for(Element element : elements) {
            String symbol = element.getSymbol();
            if(symbol.length() == 2 && symbol.charAt(0) == c && symbol.charAt(1) == cSucc)
                return true;
        }
        return false;
    }

    public String toString() {
        String out = "";
        for(Element element : elements)
            out += element.toString() + "\n";
        return out;
    }
}

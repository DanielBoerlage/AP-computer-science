package hangman;

import java.util.ArrayList;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.IOException;

import java.io.FileReader;
import java.io.BufferedReader;

public class WordList extends ArrayList<String> {

    public WordList(File file, int wordLength) throws IOException {
        super();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String word;
        while((word = reader.readLine()) != null)
            if(word.length() == wordLength)
                add(word);
        reader.close();
    }

    public void removeWordsContaining(String str) {
        for(int i = 0; i < size(); i++)
            if(get(i).contains(str))
                remove(i);
    }

    public String toString() {
        String out = "Remaining words: [";
        for(String str : this)
            out += str + ", ";
        out = out.substring(0, out.length() - 2);
        out += "]";
        return out;
    }
}

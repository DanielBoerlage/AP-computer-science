package hangman;

import java.util.ArrayList;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.IOException;

public class WordList extends ArrayList<String> {

    public WordList(File file) throws IOException {
        super(Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
    }

    public void removeWordsContaining(String str) {
        for(int i = 0; i < size(); i++)
            if(get(i).contains(str))
                remove(i);
    }

    public void keepWordsOfLength(int len) {
        for(int i = 0; i < size(); i++) {
            if(get(i).length() != len)
                remove(i);
            System.out.println("hi");
        }
    }

    public String toString() {
        String out = "Remaining words: [";
        for(String str : this)
            out += str + ", ";
        out += "]";
        return out;
    }
}

package hangman;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("H:\\My Documents\\GitHub\\AP-computer-science\\hangman\\words.txt");
        WordList w = new WordList(file);
        w.keepWordsOfLength(15);
        System.out.println(w);
    }
}

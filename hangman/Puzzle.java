package hangman;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle {

    private static final String FILE_NAME = "hangman/words.txt";
    private String word;
    private String guess;
    private ArrayList<String> wordList;

    public Puzzle() throws IOException {
        wordList = new ArrayList<String>(Files.readAllLines(new File(FILE_NAME).toPath(), StandardCharsets.UTF_8));
        guess = "";
        word = wordList.get((int)(Math.random() * wordList.size())).toLowerCase();
    }

    public boolean isUnsolved() {
        for(char c : word.toCharArray())
            if(!guess.contains(Character.toString(c)))
                return true;
        return false;
    }

    public void show() {
        for(char c : word.toCharArray())
            System.out.print((guess.contains(Character.toString(c))) ? (c + " ") : "_ ");
        System.out.print("\nguesses: ");
        for(int i = 0; i < guess.length(); i++)
            System.out.print(guess.charAt(i) + (i == guess.length()-1 ? "" : ", "));
        System.out.print("\n");
    }

    public String getWord() {
        return word;
    }

    public boolean makeGuess(String guess) {
        guess = guess.toLowerCase();
        if(guess.length() != 1 || !Character.isLetter(guess.charAt(0)) || this.guess.contains(guess))
            return true;
        this.guess += guess;
        return word.contains(guess);
    }
}

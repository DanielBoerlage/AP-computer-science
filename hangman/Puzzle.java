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

    public static final String FILE_NAME = "hangman/test-words.txt";
    protected ArrayList<Character> guesses;
    protected ArrayList<String> words;
    protected int wordLength;

    public Puzzle() throws IOException {
        words = new ArrayList<String>(Files.readAllLines(new File(FILE_NAME).toPath(), StandardCharsets.UTF_8));
        guess = "";
        String word = randomWord();
        wordLength = word.length();
        words = new ArrayList<String>();
        words.add(word);
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
        return randomWord();
    }

    public boolean makeGuess(String guess) {
        if(guess.length() != 1 || !Character.isLetter(guess.charAt(0)) || this.guess.contains(guess))
            return true;
        Character guessChar = new Character(guess.charAt(0));
        guesses.add(guessChar)
        return onMakeGuess(guessChar)
    }

    // rename
    protected boolean onMakeGuess(Character guess) {
        for(int position = 0; i < wordLength; i++)
            if(allWordsContain(guessChar), position)
                return true;
        return false;
    }

    protected boolean allWordsContain(char c, int position) {
        for(word : words)
            if(word.charAt(position) != 'c')
                return false;
        return true;
    }

    protected String randomWord() {
        return words.get((int)(Math.random() * words.size())).toLowerCase();
    }
}

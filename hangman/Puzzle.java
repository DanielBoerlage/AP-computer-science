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

    public static final String FILE_NAME = "hangman/words.txt";
    protected ArrayList<Character> guesses;
    protected ArrayList<String> words;
    protected int wordLength;
    protected String finalWord;

    public Puzzle() throws IOException {
        words = new ArrayList<String>(Files.readAllLines(new File(FILE_NAME).toPath(), StandardCharsets.UTF_8));
        guesses = new ArrayList<Character>();
        String word = randomWord().toLowerCase();
        wordLength = word.length();
        words = new ArrayList<String>();
        words.add(word);
    }

    public boolean isUnsolved() {
        return words.size() > 0;
    }

    public void show() {


//        System.out.println("wordLength: " + wordLength);


        for(int i = 0; i < wordLength; i++) {
            Character c = isUnsolved() ? words.get(0).charAt(i) : finalWord.charAt(i);
            System.out.print((allWordsContain(c, i) && guesses.contains(c)) ? (c + " ") : "_ ");
        }
        System.out.println("\nguesses: " + guesses);
    }

    public String getWord() {
        return randomWord();
    }

    public final boolean makeGuess(String guess) {
        if(guess.length() != 1 || !Character.isLetter(guess.charAt(0)))
            return true;
        Character guessChar = new Character(guess.charAt(0));
        if(guesses.contains(guessChar))
            return true;
        guesses.add(guessChar);
        return onMakeGuess(guessChar);
    }

    // rename
    protected boolean onMakeGuess(Character guess) {
        removeGuessed();
        for(int position = 0; position < wordLength; position++)
            if(allWordsContain(guess, position))
                return true;
        return false;
    }

    protected boolean allWordsContain(char c, int position) {
        for(String word : words)
            if(word.charAt(position) != c)
                return false;
        return true;
    }

    protected void removeGuessed() {
        finalWord = words.get(0);
        for(int i = words.size()-1; i >= 0; i--) {
            if(isGuessed(words.get(i)))
                words.remove(i);
        }
    }

    protected boolean isGuessed(String word) {
        for(Character c : word.toCharArray())
            if(!guesses.contains(c))
                return false;
        return true;
    }

    protected String randomWord() {
        return words.get((int)(Math.random() * words.size()));
    }
}

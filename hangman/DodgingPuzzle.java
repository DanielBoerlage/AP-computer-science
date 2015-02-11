package hangman;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DodgingPuzzle extends Puzzle {

    private int wordLength;

    public DodgingPuzzle() throws IOException {
        wordList = new ArrayList<String>(Files.readAllLines(new File(FILE_NAME).toPath(), StandardCharsets.UTF_8));
        int maxLength = 0;
        for(String word : wordList)
            if(word.length() > maxLength)
                maxLength = word.length();
        System.out.println("word length: " + maxLength);
        wordLength = getRandomWord().length();
        for(int i = wordList.size()-1; i >= 0; i--)
            if(wordList.get(i).length() != wordLength)
                wordList.remove(i);
        guess = "";
        word = ":undef";
    }

    public void show() {
        if(!word.equals(":undef")) {
            super.show();
            return;
        }
        for(char c : wordList.get(0).toCharArray())
            System.out.print("_ ");
        System.out.print("\nguesses: ");
        for(int i = 0; i < guess.length(); i++)
            System.out.print(guess.charAt(i) + (i == guess.length()-1 ? "" : ", "));
        System.out.print("\n");
    }

    public boolean isUnsolved() {
        if(word.equals(":undef"))
            return true;
        return super.isUnsolved();
    }

    public String getWord() {
        //if(word.equals(":undef"))
        //    return getRandomWord();
        return word + " " + wordList;
    }

    public boolean makeGuess(String guess) {
        guess = guess.toLowerCase();
        if(guess.length() != 1 || !Character.isLetter(guess.charAt(0)) || this.guess.contains(guess))
            return true;
        this.guess += guess;
        if(!word.equals(":undef"))
            return word.contains(guess);
        ArrayList<String> garbage = new ArrayList<String>();














        HashMap<Pattern, ArrayList<String>> patterns = new HashMap<Pattern, ArrayList<String>>();
        for (String word : wordList) {
            Pattern charPattern = new Pattern();
            for (int i = 0; i < wordLength; i++) {
                int bit = (word.charAt(i) == guess.charAt(0)) ? 1 : 0;
                charPattern.bitSum += bit;
                charPattern.bin |= bit;
                charPattern.bin <<= 1;
            }
            if(patterns.get(charPattern) == null)
                patterns.put(charPattern, new ArrayList<String>());
            patterns.get(charPattern).add(word);
        }

        System.out.println("patterns: " + patterns + "\n");

        // inital values for minimization optimization; opposite of ideal values
        Pattern idealPattern = new Pattern(~0);
        ArrayList<String> idealGroup = new ArrayList<String>();

        for (Entry<Pattern, ArrayList<String>> entry : patterns.entrySet()) {
            Pattern entryPattern = entry.getKey();
            ArrayList<String> entryWordGroup = entry.getValue();
            if(entryPattern.isPreferedOver(idealPattern, entryWordGroup.size(), idealGroup.size())) {
                idealPattern = entryPattern;
                idealGroup = entryWordGroup;
            }
        }

        System.out.println("ideal Pattern: " + idealPattern);
        System.out.println("ideal Group Size: " + idealGroup.size());
        System.out.println("ideal Group: " + idealGroup);

















        for(int i = wordList.size()-1; i >= 0; i--)
            if(wordList.get(i).toLowerCase().contains(guess)) {
                garbage.add(wordList.get(i));
                wordList.remove(i);
            }
        if(wordList.size() == 0) {
            word = garbage.get((int)(Math.random() * garbage.size())).toLowerCase();
            return true;
        }
        return false;
    }
}

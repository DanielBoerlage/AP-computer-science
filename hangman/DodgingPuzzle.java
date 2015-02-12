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

    //private int wordLength;

    public DodgingPuzzle() throws IOException {
        words = new ArrayList<String>(Files.readAllLines(new File(FILE_NAME).toPath(), StandardCharsets.UTF_8));
        guesses = new ArrayList<Character>();
        wordLength = randomWord().length();


//        System.out.println(wordLength);



        for(int i = words.size()-1; i >= 0; i--) {
            words.set(i, words.get(i).toLowerCase());
            if(words.get(i).length() != wordLength)
                words.remove(i);
        }
    }

    /*public void show() {
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
    }*/

    /*ublic boolean isUnsolved() {
        if(word.equals(":undef"))
            return true;
        return super.isUnsolved();
    }*/

    // public String getWord() {
    //     //if(word.equals(":undef"))
    //     //    return randomWord();
    //     return words.toString();
    // }

    public boolean onMakeGuess(Character guess) {




        HashMap<Pattern, ArrayList<String>> patterns = new HashMap<Pattern, ArrayList<String>>();
        for (String word : words) {
            Pattern charPattern = new Pattern();
            for (int i = 0; i < wordLength; i++) {
                int bit = (word.charAt(i) == guess) ? 1 : 0;
                charPattern.bitSum += bit;
                charPattern.bin |= bit;
                charPattern.bin <<= 1;
            }
            if(patterns.get(charPattern) == null)
                patterns.put(charPattern, new ArrayList<String>());
            patterns.get(charPattern).add(word);
        }







//        System.out.println("patterns: " + patterns + "\n");








        // inital values for minimization optimization; opposite of ideal values
        Pattern idealPattern = new Pattern(~0);
        ArrayList<ArrayList<String>> idealGroups = new ArrayList<ArrayList<String>>();
        idealGroups.add(new ArrayList<String>());

        for (Entry<Pattern, ArrayList<String>> entry : patterns.entrySet()) {
            Pattern entryPattern = entry.getKey();
            ArrayList<String> entryWordGroup = entry.getValue();
            switch(entryPattern.isPreferedOver(idealPattern, entryWordGroup.size(), idealGroups.get(0).size())) {
                case 1:
                    idealPattern = entryPattern;
                    idealGroups = new ArrayList<ArrayList<String>>();
                    idealGroups.add(entryWordGroup);
                    break;
                case 0:
                    idealPattern = entryPattern;
                    idealGroups.add(entryWordGroup);
                    break;
            }
        }












//        System.out.println("ideal Pattern: " + idealPattern);

//        System.out.println("ideal Groups: " + idealGroups);












        ArrayList<String> finalWordGroup = idealGroups.get((int)(Math.random() * idealGroups.size()));








//        System.out.println("final group: " + finalWordGroup);












        words = finalWordGroup;
        removeGuessed();
        //
        // if(wordList.size() == 0) {
        //     word = garbage.get((int)(Math.random() * garbage.size())).toLowerCase();
        //     return true;
        // }

        // bitsum is 0 no chars matched
        return idealPattern.bitSum != 0;










        // for(int i = wordList.size()-1; i >= 0; i--)
        //     if(wordList.get(i).toLowerCase().contains(guess)) {
        //         garbage.add(wordList.get(i));
        //         wordList.remove(i);
        //     }
        // if(wordList.size() == 0) {
        //     word = garbage.get((int)(Math.random() * garbage.size())).toLowerCase();
        //     return true;
        // }
        // return false;
    }
}

package hangman;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {

    /*public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HangingMan hangingMan = new HangingMan();
        Puzzle puzzle = new DodgingPuzzle();

        while (puzzle.isUnsolved() && hangingMan.isntDead()) {
            clearScreen();
            hangingMan.show();
            puzzle.show();
            System.out.print("\nMake a guess: ");
            String guess = scanner.nextLine();
            if (!puzzle.makeGuess(guess))
                hangingMan.dieSomeMore();

        }

        clearScreen();
        hangingMan.show();
        puzzle.show();
        System.out.println("\nMake a guess: ");

        if (hangingMan.isntDead()) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose! The word was " + puzzle.getWord());
        }
    }*/

    public static void main(String[] args) {
        /*HashMap<boolean[], ArrayList<String>> ex = new HashMap<boolean[], ArrayList<String>>();
        boolean[] bool = {true, false};
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("test");
        ex.put(bool, strs);

        ex.get(bool).add("woah");

        boolean[] rand = {true, true};
        ex.put(rand, new ArrayList<String>());

        boolean[] arb = {false, false, false};


        if(ex.get(arb) == null)
            ex.put(arb, new ArrayList<String>());

        System.out.println(ex);*/



        Pattern pattern = new Pattern(0);
        pattern.setBit(true, 2);
        System.out.println(pattern);
    }



    private static void clearScreen() {
        //System.out.println("\u001b[2J\u001b[H");
    }
}

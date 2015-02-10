package hangman;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws Exception {
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
    }



    private static void clearScreen() {
        System.out.println("\u001b[2J\u001b[H");
    }
}

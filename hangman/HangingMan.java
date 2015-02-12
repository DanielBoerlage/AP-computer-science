package hangman;

public class HangingMan {

    private int numWrongGuesses;

    public static final String[] TXT_IMG = {
        "+----+\n|\n|\n|\n/\\\n",
        "+----+\n|    O\n|\n|\n/\\\n",
        "+----+\n|    O\n|    +\n|\n/\\\n",
        "+----+\n|    O\n|    +-\n|\n/\\\n",
        "+----+\n|    O\n|   -+-\n|\n/\\\n",
        "+----+\n|    O\n|   -+-\n|   / \n/\\\n",
        "+----+\n|    O\n|   -+-\n|   / \\\n/\\\n",
        "+----+\n|    x\n|   -+-\n|   / \\\n/\\\n"
    };

    public HangingMan() {
        numWrongGuesses = 0;
    }

    public boolean isntDead() {
        return numWrongGuesses <= 6;
    }

    public void show() {
        System.out.println(TXT_IMG[numWrongGuesses]);
    }

    public void dieSomeMore() {
        numWrongGuesses++;
    }
}

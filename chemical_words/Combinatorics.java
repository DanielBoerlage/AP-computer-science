package chemical_words;

public class Combinatorics {

    /**
     *@param n number of elements to be combined
     */
    public static Combination[] getCombinations(int n) {
        for(int bin = 0; bin < n)
    }

}

class Combination {

    private boolean[] combination;

    public Combination(boolean... copyFrom) {
        combination = new boolean[copyFrom.length];
        System.arraycopy(copyFrom, 0, combination, 0, copyFrom.length);
    }

    public boolean[] getCombination() {
        return combination;
    }
}

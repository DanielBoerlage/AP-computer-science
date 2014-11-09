package chemical_words;

public class Combinatorics {

    /**
     *@param n number of elements to be combined
     */
    //public static Combination[] getCombinations(int n) {
    //    Combination[] out = new Combination[]
    //    for(int bin = 0; bin < n; bin++)
    //}

    public static Combination getCombination(boolean[] copyFrom) {
        return new Combination(copyFrom);
    }


    static class Combination {

        private boolean[] combination;

        private Combination(boolean[] copyFrom) {
            combination = new boolean[copyFrom.length];
            System.arraycopy(copyFrom, 0, combination, 0, copyFrom.length);
        }

        public boolean[] getCombination() {
            return combination;
        }
    }

}

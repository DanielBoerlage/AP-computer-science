package chemical_words;

public class Combinatorics {

<<<<<<< HEAD
    public static Combination[] getCombinations(int nElements) {  // adjust for higher bit sums precedence
        int nCombinations = (int)Math.pow(2, nElements);
        Combination[] out = new Combination[nCombinations];
        for(int bin = 0; bin < nCombinations; bin++) {
            boolean[] boolCombo = new boolean[nElements];
            for(int dig = 0; dig < nElements; dig++)
                boolCombo[dig] = (bin >> dig & 1) == 1;
            out[bin] = new Combination(boolCombo);
        }
        return out;
    }

    public static class Combination {

        private boolean[] combination;

        private Combination(boolean[] copyFrom) {
            combination = new boolean[copyFrom.length];
            System.arraycopy(copyFrom, 0, combination, 0, copyFrom.length);
        }

        public boolean getStateAt(int i) {
            return combination[i];
        }

        public boolean[] getCombination() {
            return combination;
        }

        public int getSum() {
            int sum = 0;
            for(boolean bool : combination) {
                if(bool)
                    sum++;
            }
            return sum;
        }

        public String toString() {
            String out = "";
            for(int i = 0; i < combination.length; i++)
                out += "[" + i + "] " + combination[i] + "\n";
            return out;
        }
    }

}

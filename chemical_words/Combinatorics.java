package chemical_words;

public class Combinatorics {

	private static final double LN2 = 0.69314718056;

	public Combination[] getCombinations(int n) {
		int size = Math.pow(2, n);
		Combination[] combos = new Combination[size];
		for(int b = 0; b < size; b++) {
			boolean[] binaryCombination = new boolean[n];
			for(int d = 0; d < n; d++)
				binaryCombination[d] = (b >> d) & 1 == 1;
			combos[b] = new Combination(binaryCombination);
		}
		return combos;
	}

	public class Combination {

		private boolean[] combination;

		public Combination(boolean[] copyFrom) {
			combination = new boolean[copyFrom.length];
			for(int i = 0; i < copyFrom.length; i++)
				cobination[i] = copyFrom[i];
		}

		public boolean getCombination() {
			return combination;
		}
	}
}
package tictactoe;

class Grid {

	private char[][] grid;

	public Grid() {
		grid = new char[3][3];
	}

	public Grid(Grid copyFrom) {
		grid = new char[3][3];
		for(int i = 0; i < 9; i++)
			put(copyFrom.get(i), i);
	}

	public void reset() {
		for(int i = 0; i < 9; i++) 
			put(' ', i);
	}

	public char get(int position) {
		return grid[position % 3][position / 3];
	}

	public void put(char c, int position) {
		grid[position % 3][position / 3] = c;
	}

	public boolean isVacant(int position) {
		return get(position) == ' ';
	}

	public Grid putAndPop(char c, int position) {
		Grid out = new Grid(this);
		out.put(c, position);
		return out;
	}

	public char[] flatten() {
		char[] out = new char[9];
		for(int i = 0; i < 9; i++)
			out[i] = get(i);
		return out;
	}

	public boolean isFull() {
		for(int i = 0; i < 9; i++) {
			if(get(i) == ' ')
				return false;
		}
		return true;
	}

	public boolean isLegalMove(int position) {
		return (position >= 0) && (position <= 8) && isVacant(position);
	}

	public boolean win() {
		return false;
	}

	public boolean lose() {
		return false;
	}
}
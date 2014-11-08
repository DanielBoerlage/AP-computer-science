package tictactoe;

class Grid {

	/* position
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 */

	private char[][] grid;  // [col][row]

	public Grid() {
		grid = new char[3][3];
		reset();
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

	public char get(int col, int row) {
		return grid[col][row];
	}

	public void put(char c, int position) {
		grid[position % 3][position / 3] = c;
	}

	public boolean isVacant(int position) {
		return get(position) == ' ';
	}

	public int nVacant() {
		int n = 0;
		for(int i = 0; i < 9; i++) {
			if(get(i) == ' ')
				n++;
		}
		return n;
	}

	public Grid putAndPop(char c, int position) {
		Grid out = new Grid(this);
		out.put(c, position);
		return out;
	}

	public boolean isLegalMove(int position) {
		return (position >= 0) && (position <= 8) && isVacant(position);
	}

	public boolean isWin(char playerChar) {
		for(int i = 0; i < 3; i++) { // does all 6 horizontal and vertical checks
			if(grid[i][0] == playerChar && grid[i][1] == playerChar && grid[i][2] == playerChar ||
			   grid[0][i] == playerChar && grid[1][i] == playerChar && grid[2][i] == playerChar)
				return true;
		}
		return grid[0][0] == playerChar && grid[1][1] == playerChar && grid[2][2] == playerChar ||
			   grid[2][0] == playerChar && grid[1][1] == playerChar && grid[0][2] == playerChar;
	}

	public boolean isLoss(char opponentChar) { // remove
		return isWin(opponentChar);
	}

	public boolean isDraw(char playerChar, char opponentChar) {
		return (nVacant() == 0) && !isWin(playerChar) && !isWin(opponentChar);
	}

	public int getWinner(char player1Char, char player2Char) {
		if(isWin(player1Char))
			return 1;
		if(isWin(player2Char))
			return 2;
		if(isDraw(player1Char, player2Char))  // cahnge
			return 0;
		return -1;
	}

	//this is a test
}

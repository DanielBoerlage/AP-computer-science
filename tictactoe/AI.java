package tictactoe;

public class AI implements Player {

	private char playerChar, opponentChar;
	private double clumsiness;  // if this is zero, ai will never lose

	public AI(char playerChar, char opponentChar, double clumsiness) {
		this.playerChar = playerChar;
		this.opponentChar = opponentChar;
		this.clumsiness = clumsiness;
	}

	public int makeMove(Grid grid) {
		if(clumsiness > Math.random())
			return randomMove(grid);
		int bestVal = -1, bestPosition = 0;
		for(int i = 0; i < 9; i++) {
			if(grid.isVacant(i)) {
				int moveVal = findMove(grid.putAndPop(playerChar, i), false);
				if(moveVal > bestVal) {
					bestVal = moveVal;
					bestPosition = i;
				}
			}
		}
		return bestPosition;
	}

	private int findMove(Grid grid, boolean friendlyTurn) {
		if(grid.isWin(playerChar))
			return 1;
		if(grid.isLoss(opponentChar))
			return -1;
		if(grid.isFull())
			return 0;
		int best = (friendlyTurn) ? -1 : 1;
		for(int i = 0; i < 9; i++) {
			if(grid.isVacant(i)) {
				int child = findMove(grid.putAndPop((friendlyTurn) ? playerChar : opponentChar, i), !friendlyTurn);
				best = (friendlyTurn) ? Math.max(best, child) : Math.min(best, child);
			}
		}
		return best;
	}

	private int randomMove(Grid grid) {
		int position = (int)(Math.random() * 9);
		if(!grid.isVacant(position))
			return randomMove(grid);
		return position;
	}

	public char getPlayerChar() {
		return playerChar;
	}
}
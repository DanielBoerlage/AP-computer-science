package tictactoe;

public class AI implements Player {

	public char playerChar, opponentChar;

	int makeMove(Grid grid) {
		int bestVal = 0, bestPosition = 0;
		for(int i = 0; i < 9; i++) {
			int moveVal = findMove(grid, true);
		}
	}

	int findMove(Grid grid, boolean friendlyTurn) {
		if(grid.win(playerChar))
			return 1;
		if(grid.lose(playerChar))
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
}
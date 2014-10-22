package tictactoe;

public class AI implements Player {

	/*

	0  = draw
	1  = win
	-1 = loss

	0 1 2
	3 4 5
	6 7 8

	*/

	int makeMove() {
		
	}

	int findMove(Grid grid, boolean friendlyTurn) {
		if(grid.win())
			return 1;
		if(grid.lose())
			return -1;
		if(grid.isFull())
			return 0;
		int best = (friendlyTurn) ? -1 : 1;
		for(int i = 0; i < 9; i++) {
			char c = grid.get(i);
			if(c == ' ') {
				int child = findMove(grid.putAndPop((friendlyTurn) ? friendlyChar : opponentChar, i), !friendlyTurn);
				best = (friendlyTurn) ? Math.max(best, child) : Math.min(best, child);
			}
		}
		return best;
	}
}
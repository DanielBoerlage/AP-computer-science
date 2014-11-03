package tictactoe;

import java.util.ArrayList;

public class AI {

	protected char playerChar, opponentChar;

	public AI(char playerChar, char opponentChar) {
		this.playerChar = playerChar;
		this.opponentChar = opponentChar;
	}

	public boolean isPerfectMove(Grid grid, int move) {  // needs to be static
		ArrayList<Integer>[] moves = getMoves(grid);
		if(!moves[1].isEmpty())
			return moves[1].contains(move);
		if(!moves[0].isEmpty())
			return moves[0].contains(move);
		return true;
	}

	protected ArrayList<Integer>[] getMoves(Grid grid) {
		ArrayList<Integer>[] out = new ArrayList[2];
		out[0] = new ArrayList<Integer>();  // test for need
		out[1] = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			if(grid.isVacant(i)) {
				int moveVal = findMove(grid.putAndPop(playerChar, i), false);
				if(moveVal >= 0)
					out[moveVal].add(i);
			}
		}
		return out;
	}

	private int findMove(Grid grid, boolean friendlyTurn) {
		if(grid.isWin(playerChar))
			return 1;
		if(grid.isLoss(opponentChar))
			return -1;
		if(grid.isDraw(playerChar, opponentChar))
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

	public char getPlayerChar() {
		return playerChar;
	}
}
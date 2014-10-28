package tictactoe;

import java.util.ArrayList;

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
		ArrayList<Integer>[] moves = getMoves(grid);
		if(!moves[1].isEmpty())
			return moves[1].get((int)(Math.random() * moves[1].size()));
		if(!moves[0].isEmpty())
			return moves[0].get((int)(Math.random() * moves[0].size()));
		return randomMove(grid);
	}

	private ArrayList<Integer>[] getMoves(Grid grid) {
		ArrayList<Integer>[] out = new ArrayList[2];
		out[0] = new ArrayList<Integer>();
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

	public boolean isPerfectMove(Grid grid, int move) {  // needs to be static
		ArrayList<Integer>[] moves = getMoves(grid);
		if(!moves[1].isEmpty())
			return moves[1].contains(move);
		if(!moves[0].isEmpty())
			return moves[0].contains(move);
		return true;

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
package tictactoe;

import java.util.ArrayList;

public class ClumsyAI extends AI implements Player {

	private double clumsiness;  // if this is zero, ai will never lose

	public ClumsyAI(char playerChar, char opponentChar, double clumsiness) {
		super(playerChar, opponentChar);
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

	private int randomMove(Grid grid) {
		int position = (int)(Math.random() * 9);
		if(!grid.isVacant(position))
			return randomMove(grid);
		return position;
	}
}
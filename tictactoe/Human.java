package tictactoe;

import java.awt.Point;
import java.util.ArrayList;

public class Human implements Player {

	private char playerChar;
	private Terminal terminal;
	private ArrayList<Boolean> perfectionHistory;
	private AI monitor;

	public Human(char playerChar, char opponentChar, Terminal terminal) {
		this.playerChar = playerChar;
		this.terminal = terminal;
		monitor = new AI(playerChar, opponentChar);
		perfectionHistory = new ArrayList<Boolean>();
	}

	public int makeMove(Grid grid) {
		synchronized(terminal) {
			try {
				while(!terminal.hasMousePos())
					terminal.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Point p = terminal.getAndInvalidateMousePos();
		int position = ((p.x - 44) / 29) + 3 * ((p.y - 56) / 28);  // fix for window style
		if(!grid.isLegalMove(position))
			return makeMove(grid);
		if(grid.nVacant() < 9 && grid.nVacant() > 1) {
			perfectionHistory.add(monitor.isPerfectMove(grid, position));
			if(perfectionHistory.size() > 40)
				perfectionHistory.remove(0);
		}
		return position;
	}

	public double getPerfection() {
		if(perfectionHistory.isEmpty())  // assume player sucks
			return 0;
		double weightedSum = 0, totalWeight = 0, weight = 1;
		for(int i = perfectionHistory.size() - 1; i >= 0; i--) {
			weightedSum += (perfectionHistory.get(i) ? 1 : 0) * weight;
			totalWeight += weight;
			weight *= .9;
		}
		return weightedSum / totalWeight;
	}

	public char getPlayerChar() {
		return playerChar;
	}
}
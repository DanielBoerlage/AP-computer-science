package tictactoe;

import java.awt.Point;
import java.util.ArrayList;

public class Human implements Player {

	private char playerChar;
	private Terminal terminal;
	private ArrayList<Boolean> mistakeHistory;
	private AI monitor;

	public Human(char playerChar, char opponentChar, Terminal terminal) {
		this.playerChar = playerChar;
		this.terminal = terminal;
		monitor = new AI(playerChar, opponentChar, 0.0);
		mistakeHistory = new ArrayList<Boolean>();  // true = mistake
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
		int position = ((p.x - 44) / 29) + 3 * ((p.y - 56) / 28);
		if(!grid.isLegalMove(position))
			return makeMove(grid);

		mistakeHistory.add(!monitor.isPerfectMove());
		if(mistakeHistory.size() > 40)
			mistakeHistory.remove(0);

		return position;
	}

	public char getPlayerChar() {
		return playerChar;
	}
}

//email: byngcompsci@gmail.com
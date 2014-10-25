package tictactoe;

import java.awt.Point;

public class Human implements Player {

	private char playerChar;
	private Terminal terminal;

	public Human(char playerChar, Terminal terminal) {
		this.playerChar = playerChar;
		this.terminal = terminal;
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
		return position;
	}

	public char getPlayerChar() {
		return playerChar;
	}
}
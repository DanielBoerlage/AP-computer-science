package tictactoe;

import java.awt.Point;

public class Human implements Player {

	public char playerChar;
	private Terminal terminal;

	public Human(Terminal terminal) {
		this.terminal = terminal;
	}

	public int makeMove(Grid grid) {
		synchronized(terminal) {
			try {
				while(!terminal.hasMousePos())
					terminal.wait()
			} catch(InterruptionException e) {
				e.printStackTrace();
			}
		}
		Point p = terminal.getAndInvalidateMousePos();
		int position = ((p.x - 44) / 29) + 3 * ((p.y - 56) / 28);
		if(!grid.isLegalMove(position))
			return makeMove(grid);
		return position;
	}
}
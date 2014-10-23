package tictactoe;

import java.awt.Point;

public class Human implements Player{

	public char friendlyChar;
	private Terminal terminal;


	public int makeMove() {
		synchronized(terminal) {
			try {
				while(!terminal.hasMousePos())
					terminal.wait()
			} catch(InterruptionException e) {
				e.printStackTrace();
			}
		}
		Point p = terminal.getAndInvalidateMousePos();
		int col = (p.x - 44) / 29;
		int row = (p.y - 56) / 28;
		if(invalidMove(col, row))
			return makeMove();
		return col + 3 * row;
	}
}
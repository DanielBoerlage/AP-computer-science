package tictactoe;

import java.awt.Point;
import java.util.ArrayList;

public class Human implements Player {

	private char playerChar;
	private Terminal terminal;
	private ArrayList<Boolean> mistakeHistory;

	public Human(char playerChar, Terminal terminal) {
		this.playerChar = playerChar;
		this.terminal = terminal;
		mistakeHistory = new ArrayList<Boolean>();
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

		if(AI.)


		return position;
	}

	public void onMistake() {
		mistakeHistory.add(true);
		if(mistakeHistory.size() > 40)
			mistakeHistory.remove(0);
	}

	public void onPerfectMove() {
		mistakeHistory.add(false);
	}

	public char getPlayerChar() {
		return playerChar;
	}
}
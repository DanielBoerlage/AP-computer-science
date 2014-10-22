package tictactoe;


import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.GUIScreen;

public class Board extends Window implements Runnable {

	final String PLUS = "\u253c";
	final String VERT = " \u2502 ";
	final String HORIZ = "\u2500\u2500\u2500";
	final String HORIZBAR = "\n " +  HORIZ + PLUS + HORIZ + PLUS + HORIZ + "\n";

	char[][] grid;  // [column] [row]
	Label text;
	GUIScreen parent;

	public Board(GUIScreen parent) {
		super("Game");
		this.parent = parent;
		grid = new char[3][3];
		reset();
		text = new Label(drawText());
		addComponent(text);
	}

	public void run() {
		parent.showWindow(this, GUIScreen.Position.NEW_CORNER_WINDOW);
	}

	public void reset() {
		for(int i = 0; i < 9; i++)
			grid[i/3][i%3] = ' ';
	}

	public boolean isFinished() {
		for(int i = 0; i < 9; i++) {
			if(grid[i/3][i%3] == ' ')
				return false;
		}
		return true;
	}

	public boolean isVacant(int col, int row) {
		return grid[col][row] == ' ';
	}

	public void put(char c, int col, int row) {
		if(grid[col][row] != ' ')  // vacancy check
			return;
		grid[col][row] = c;
		text.setText(drawText());
	}

	int getWinner() {
		for(int i = 0; i < 8; i++) {
			char[] line = triad(i);
			if(line[0] == line[1] && line[1] == line[2]) {
				if(line[0] == 'X')
					return Main.startPlayer;
				else if(line[0] == 'O')
					return Main.otherPlayer(Main.startPlayer);
			}
		}
		return 0;
	}

	/*

	position

	0 1 2
	3 4 5
	6 7 8


	ways of winning (traid and codes)

     0 1 2
	3\| |/
	 -+-+-
	4 |X|
	 -+-+-
	5/| |\
    7     6

	*/

	char[] triad(int code) {
		if(code < 3)
			return new char[] {grid[0][code], grid[1][code], grid[2][code]};
		if(code < 6)
			return grid[code/3];
		if(code < 7)
			return new char[] {grid[0][0], grid[1][1], grid[2][2]};
		return new char[] {grid[2][0], grid[1][1], grid[0][2]};
	}

	int triadToPosition(int triadCode, int index) {
		if(triadCode < 3)
			return triadCode + 3 * index;
		if(triadCode < 6)
			return index + 3 * (triadCode - 3);
		if(triadCode < 7)
			return 4 * index;
		return 2 + 2 * index;
	}

	private String drawText() {
		return drawRow(0) + HORIZBAR + drawRow(1) + HORIZBAR + drawRow(2) + "\n player" + Main.otherPlayer(Main.playerTurn) + " turn";
	}

	private String drawRow(int c) {
		return "  " + grid[0][c] + VERT + grid[1][c] + VERT + grid[2][c] + " ";
	}
}
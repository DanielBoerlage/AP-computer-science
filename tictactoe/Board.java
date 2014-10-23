package tictactoe;


import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.GUIScreen;

public class Board extends Window {

	final String CROSS = "\u253c";
	final String VERT = " \u2502 ";
	final String HORIZ = "\u2500\u2500\u2500";
	final String HORIZBAR = "\n" + HORIZ + CROSS + HORIZ + CROSS + HORIZ + "\n";

	private Grid grid;
	private Label text;

	public Board(Terminal parent) {
		super("Game");
		grid = new Grid();
		text = new Label(drawText());
		addComponent(text);
		parent.showWindow(this, GUIScreen.Position.NEW_CORNER_WINDOW);
	}

	public Grid getGrid() {
		return grid;
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
		return drawRow(0) + HORIZBAR + drawRow(1) + HORIZBAR + drawRow(2);
	}

	private String drawRow(int c) {
		return grid.get(0, c) + VERT + grid.get(1, c) + VERT + grid.get(2, c);
	}
}
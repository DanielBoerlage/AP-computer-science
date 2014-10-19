package tictactoe;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.Border;

public class Board extends Window {

	char[][] grid;  // [column] [row]

	public Board() {
		super("Game");

		grid = new char[3][3];
		for(int i = 0; i < 9; i++)
			grid[i/3][i%3] = ' ';
		grid[1][1] = 'X';

		char horiz = '\u2500';
		char vert = '\u2502';
		char plus = '\u253c';

		String horizbar = "" + horiz + horiz + horiz + plus + horiz + horiz + horiz + plus + horiz + horiz + horiz;

        addComponent(new Label(" X " + vert + "   " + vert + " X \n" + horizbar +
							   "\n O " + vert + "   " + vert + " X \n" + horizbar +
							   "\n   " + vert + "   " + vert + " O "));
	}

	@Override
	public void onKeyPressed(Key key) {
		close();
	}

	public String draw() {
		String horizBar = "-+-+-";
		return row(0) + '\n' + horizBar + '\n' + row(1) + '\n' + horizBar + '\n' + row(2);
	}

	private String row(int c) {
		return grid[0][c] + "|" + grid[1][c] + "|" + grid[2][c];
	}
}
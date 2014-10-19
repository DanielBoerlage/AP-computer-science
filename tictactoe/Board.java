package tictactoe;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.Border;

public class Board extends Window {

	final String PLUS = "\u253c";
	final String VERT = " \u2502 ";
	final String HORIZ = "\u2500\u2500\u2500";
	final String HORIZBAR = "\n" +  HORIZ + PLUS + HORIZ + PLUS + HORIZ + "\n";

	char[][] grid;  // [column] [row]
	Label text;

	public Board() {
		super("Game");
		grid = new char[3][3];
		for(int i = 0; i < 9; i++)
			grid[i/3][i%3] = ' ';

		text = new Label(drawText());
		addComponent(text);
	}

	public boolean isFinished() {
		for(int i = 0; i < 9; i++) {
			if(grid[i/3][i%3] == ' ')
				return false;
		}
		return true;
	}

	public void put(char c, int col, int row) {
		grid[col][row] = c;
		text.setText(drawText());
	}

	private String drawText() {
		return row(0) + HORIZBAR + row(1) + HORIZBAR + row(2);
	}

	private String row(int c) {
		return " " + grid[0][c] + VERT + grid[1][c] + VERT + grid[2][c] + " ";
	}
}
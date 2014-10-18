package tictactoe;

import com.googlecode.lanterna.terminal.swing.SwingTerminal;

public class Board {

	char[][] grid;  // [row] [column]

	public Board() {
		grid = new char[3][3];
		for(int i = 0; i < 9; i++)
			grid[i/3][i%3] = ' ';
		grid[1][1] = 'X';
	}

	/*

	 | |
	-+-+-
	 | |
    -+-+-
     | |

	*/

	public void draw(SwingTerminal terminal) {
		String horizBar = "-+-+-";
		String print = row(0) + horizBar + row(1) + horizBar + row(2);
		putStr(terminal, row(0));
		terminal.moveCursor(0, 1);
		putStr(terminal, horizBar);
		terminal.moveCursor(0, 2);
		putStr(terminal, row(1));
		terminal.moveCursor(0, 3);
		putStr(terminal, horizBar);
		terminal.moveCursor(0, 4);
		putStr(terminal, row(2));
	}

	private String row(int c) {
		return grid[0][c] + "|" + grid[1][c] + "|" + grid[2][c];
	}

	private void putStr(SwingTerminal terminal, String str) {
		for(int i = 0; i < str.length(); i++)
			terminal.putCharacter(str.charAt(i));
	}
}
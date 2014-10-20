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
	final String HORIZBAR = "\n" +  HORIZ + PLUS + HORIZ + PLUS + HORIZ + "\n";

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
		/*addComponent(new Button("New window", new Action() {
                @Override
                public void doAction() {
                	close();
                    //getOwner().showWindow(new Board());
                }
        }));*/
		/*addComponent(new Button("close", new Action() {
            @Override
            public void doAction() {
                MessageBox.showMessageBox(getOwner(), "Information", "When you close this dialog, the owner window will close too");
                close();
                ((Terminal) getOwner()).updatePLS();
            }
        }));*/
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

	public void put(char c, int col, int row) {
		if(grid[col][row] != ' ')  // vacancy check
			return;
		grid[col][row] = c;
		text.setText(drawText());
	}

	public int getWinner() {
		for(int i = 0; i < 3; i++) {  // does all 6 horizontal and vertical checks
			if(grid[i][0] == 'X' && grid[i][1] == 'X' && grid[i][2] == 'X' || 
			   grid[0][i] == 'X' && grid[1][i] == 'X' && grid[2][i] == 'X')
				return Main.startPlayer;
			if(grid[i][0] == 'O' && grid[i][1] == 'O' && grid[i][2] == 'O' || 
			   grid[0][i] == 'O' && grid[1][i] == 'O' && grid[2][i] == 'O')
				return Main.otherPlayer(Main.startPlayer);
		}
		if(grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X' || 
		   grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X')
				return Main.startPlayer;
		if(grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O' || 
		   grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O')
				return Main.otherPlayer(Main.startPlayer);
		return 0;  // draw
	}

	private String drawText() {
		return row(0) + HORIZBAR + row(1) + HORIZBAR + row(2) + "\n player " + Main.otherPlayer(Main.playerTurn) + " turn";
	}

	private String row(int c) {
		return " " + grid[0][c] + VERT + grid[1][c] + VERT + grid[2][c] + " ";
	}
}
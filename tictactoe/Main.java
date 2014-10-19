package tictactoe;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.gui.GUIScreen;

import javax.swing.JFrame;

public class Main {

	public int startPlayer, playerTurn;
	Board board;

	public static void main(String[] args) {

		Terminal terminal = new Terminal();
		startPlayer = 2;   // will changed to player 1 in first beginGame() call
		while(true) 
			initialize board
			pick starting player
			while(no winner)
				player 1 turn
				player 2 turn
			if(!play again)
				exit*/
	}

	public static void beginGame() {
		board = new Board();
		playerTurn = startPlayer = (startPlayer == 2) ? 1 : 2;
		while(!board.isFinished()) {

		}
	}

	public static void takeTurn(int col, int row) {
		board.put((playerTurn == 1) ? 'X' : 'O', col, row);
		playerTurn = (playerTurn == 1) 
	}
}
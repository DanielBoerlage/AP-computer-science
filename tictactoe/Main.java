package tictactoe;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.gui.GUIScreen;

import javax.swing.JFrame;

public class Main {

	public static int startPlayer, playerTurn;
	static Board board;
	static Terminal terminal;
	static ScoreBoard scoreBoard;

	public static void main(String[] args) throws InterruptedException {
		terminal = new Terminal();
		board = new Board(terminal);
		scoreBoard = new ScoreBoard(terminal);
		startPlayer = 2;  // will be 1 in first game
		beginGame();
		Thread scoreBoardThread = new Thread(scoreBoard);
		Thread boardThread = new Thread(board);
		scoreBoardThread.start();
		boardThread.start();
	}

	public static void beginGame() {
		board.reset();
		playerTurn = startPlayer = otherPlayer(startPlayer);
	}

	public static void takeTurn(int col, int row) {
		board.put((playerTurn == startPlayer) ? 'X' : 'O', col, row);
		playerTurn = otherPlayer(playerTurn);
		if(board.getWinner() != 0 || board.isFinished()) {
			scoreBoard.addWinner(board.getWinner());
			beginGame();
			terminal.invalidate();
		}
	}

	public static int otherPlayer(int player) {
		return (player == 1) ? 2 : 1;
	}
}
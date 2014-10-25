package tictactoe;



public class Main {

	private static Terminal terminal;
	private static Board board;
	private static ScoreBoard scoreBoard;
	private static Player player1, player2;
	private static int startingPlayer, playerTurn;

	public static void main(String[] args) {
		initGUI();
		initPlayers();
		while(true) {
			takeTurn((playerTurn == 1) ? player1 : player2);
		}
	}

	private static void initGUI() {
		terminal = new Terminal(64, 10);
		board = new Board(terminal);
		scoreBoard = new ScoreBoard(terminal);
		new Thread(scoreBoard).start();
		new Thread(board).start();
	}

	private static void initPlayers() {
		player1 = new Human('X', terminal);
		player2 = new Human('O', terminal);
		playerTurn = startingPlayer = 1;
	}

	private static void takeTurn(Player player) {
		board.put(player.getPlayerChar(), player.makeMove(board.getGrid()));
		playerTurn = (playerTurn == 1) ? 2 : 1;
		int winner = board.getGrid().getWinner('X', 'O');
		if(winner == -1)  // no winner or draw
			return;
		scoreBoard.incWinCount(winner);
		restart();
	}

	private static void restart() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		board.reset();
		playerTurn = startingPlayer = (startingPlayer == 1) ? 2 : 1;
	}
}
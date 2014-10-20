package tictactoe;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.GUIScreen;

public class ScoreBoard extends Window implements Runnable {

	int player1Wins, player2Wins, draws;
	Label text;
	GUIScreen parent;

	public ScoreBoard(GUIScreen parent) {
		super("Scoreboard");
		this.parent = parent;
		text = new Label(drawText());
		addComponent(text);
	}

	public void run() {
		parent.showWindow(this, GUIScreen.Position.CENTER);
	}

	public void addWinner(int winner) {
		if(winner == 0)
			draws++;
		else if(winner == 1)
			player1Wins++;
		else 
			player2Wins++;
	}

	private String drawText() {
		return "Player 1 wins: " + player1Wins + "\nPlayer 2 wins: " +  player2Wins + "\nDraws:         " + draws;
	}
}
package tictactoe;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.GUIScreen;

public class ScoreBoard extends Window implements Runnable {

	int[] winCount;
	Label text;
	GUIScreen parent;

	public ScoreBoard(GUIScreen parent) {
		super("Scoreboard");
		this.parent = parent;
		winCount = new int[3];
		text = new Label(drawText());
		addComponent(text);
	}

	public void run() {
		parent.showWindow(this, GUIScreen.Position.CENTER);
	}

	public void addWinner(int winner) {
		winCount[winner]++;
		text.setText(drawText());
	}

	private String drawText() {
		return "Player1 wins: " + winCount[1] + "\nPlayer2 wins: " +  winCount[2] + "\nDraws:        " + winCount[0];
	}
}
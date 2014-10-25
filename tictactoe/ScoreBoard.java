package tictactoe;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.GUIScreen;

public class ScoreBoard extends Window implements Runnable {

	private int[] winCount;
	private Label text;
	private Terminal parent;

	public ScoreBoard(Terminal parent) {
		super("Scoreboard");
		this.parent = parent;
		winCount = new int[3];
		text = new Label(drawText());
		addComponent(text);
	}

	public void run() {
		parent.showWindow(this, GUIScreen.Position.CENTER);
	}

	public void incWinCount(int winner) {
		winCount[winner]++;
		text.setText(drawText());
	}

	private String drawText() {
		return String.format("Player X wins: %3d\nPlayer O wins: %3d\nDraws: %11d", winCount[1], winCount[2], winCount[0]);
	}
}
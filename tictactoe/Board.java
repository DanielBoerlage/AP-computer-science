package tictactoe;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.GUIScreen;

public class Board extends Window implements Runnable {

	private static final String CROSS = "\u253c";
	private static final String VERT = " \u2502 ";
	private static final String HORIZ = "\u2500\u2500\u2500";
	private static final String HORIZBAR = "\n" + HORIZ + CROSS + HORIZ + CROSS + HORIZ + "\n";

	private Grid grid;
	private Label text;
	private Terminal parent;

	public Board(Terminal parent) {
		super("Game");
		grid = new Grid();
		text = new Label(drawText());
		addComponent(text);
		this.parent = parent;
	}

	public void run() {
		parent.showWindow(this, GUIScreen.Position.NEW_CORNER_WINDOW);
	}

	public void put(char c, int position) {
		grid.put(c, position);
		text.setText(drawText());
	}

	public void reset() {
		grid.reset();
		text.setText(drawText());
	}

	public Grid getGrid() {
		return grid;
	}

	private String drawText() {
		return drawRow(0) + HORIZBAR + drawRow(1) + HORIZBAR + drawRow(2);
	}

	private String drawRow(int c) {
		return " " + grid.get(0, c) + VERT + grid.get(1, c) + VERT + grid.get(2, c) + " ";
	}
}
package tictactoe;

import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.Border;

public class Terminal implements MouseListener {

	SwingTerminal console;
	GUIScreen gui;
	JFrame frame;

	public Terminal() {
		console = TerminalFacade.createSwingTerminal(21, 10);
		gui = TerminalFacade.createGUIScreen(console);
		gui.getScreen().startScreen();

		frame = console.getJFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic tac toe");
		frame.addMouseListener(this);

		gui.showWindow(board, GUIScreen.Position.NEW_CORNER_WINDOW);
	}

	public void mouseReleased(MouseEvent e) {
		board.update('X', (e.getX() - 36) / 29, (e.getY() - 56) / 28);
		Main.takeTurn((e.getX() - 36) / 29, (e.getY() - 56) / 28);
	}
	public void mouseClicked(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
}
/*package tictactoe;

import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.dialog.DialogResult;

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
	}

	public boolean promptRestart(int winner) {
		MessageBox.showMessageBox(gui, "title", "message", DialogButtons.YES_NO);
		//return (MessageBox.showMessageBox(gui, "title", "message", DialogButtons.YES_NO) == DialogResult.YES);
		return true;
	}

	public void showWindow(Window window) {
		gui.showWindow(window);
	}

	public void mouseReleased(MouseEvent e) {
		Main.takeTurn((e.getX() - 36) / 29, (e.getY() - 56) / 28);
	}
	public void mouseClicked(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
}*/
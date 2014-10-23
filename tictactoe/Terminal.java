package tictactoe;

import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.dialog.DialogResult;

public class Terminal extends GUIScreen implements MouseListener {

	private Point mousePos;

	public Terminal() {
		super(new Screen(TerminalFacade.createSwingTerminal(64,11)));
		SwingTerminal console = (SwingTerminal) getScreen().getTerminal();
		getScreen().startScreen();

		JFrame frame = console.getJFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic tac toe");
		frame.addMouseListener(this);
	}

	public boolean updatePLS() {
		return update();
	}

	public boolean hasMousePos() {
		return mousePos != null;
	}

	public boolean getAndInvalidateMousePos() {
		Point ret = mousePos.clone();
		mousePos = null;
		return ret;
	}

	public void mouseReleased(MouseEvent e) {
		synchronized(this) {
			mousePos = e.getPoint();
			notify();
		}
	}
	public void mouseClicked(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
}
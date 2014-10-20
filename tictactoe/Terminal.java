package tictactoe;

import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

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

	public void mouseReleased(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());
		Main.takeTurn((e.getX() - 44) / 29, (e.getY() - 56) / 28);
	}
	public void mouseClicked(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
}
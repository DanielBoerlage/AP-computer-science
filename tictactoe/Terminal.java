package tictactoe;

import javax.swing.JFrame;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.Border;

public class Terminal {

	SwingTerminal console;
	GUIScreen gui;
	JFrame frame;

	public Terminal() {
		console = TerminalFacade.createSwingTerminal(29, 10);
		gui = TerminalFacade.createGUIScreen(console);

		gui.getScreen().startScreen();


		frame = console.getJFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic tac toe");

		gui.showWindow(new Board(), GUIScreen.Position.NEW_CORNER_WINDOW);
	}
}
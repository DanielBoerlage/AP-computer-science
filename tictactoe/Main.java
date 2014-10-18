package tictactoe;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		//Terminal terminal = TerminalFacade.createTerminal();
        SwingTerminal terminal = TerminalFacade.createSwingTerminal();
        terminal.enterPrivateMode();
        JFrame frame = terminal.getJFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic tac toe");
        terminal.setCursorVisible(false);
        Board board = new Board();
        board.draw(terminal);
	}
}
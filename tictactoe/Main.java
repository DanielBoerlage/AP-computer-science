package tictactoe;

import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalFacade;

public class Main {

	public static void main(String[] args) {
		Terminal terminal = TerminalFacade.createTerminal();
		terminal.enterPrivateMode();
		terminal.moveCursor(10, 5);
    	terminal.putCharacter('H');
    	terminal.putCharacter('e');
    	terminal.putCharacter('l');
    	terminal.putCharacter('l');
    	terminal.putCharacter('o');
    	terminal.putCharacter('!');
    	terminal.moveCursor(0, 0);
    	terminal.exitPrivateMode();
	}
}
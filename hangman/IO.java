package hangman;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class IO {

    JFrame jFrame;
    KeyAdapter keyAdapter;

    public IO() {
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.addKeyListener(keyAdapter = new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        });
    }

    /*public static char getChar() {
        try {
            return new Character(Scanner.next());
        } catch()
    }*/
}

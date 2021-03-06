package plane;

import java.awt.event.*;

import javax.swing.*;

import plane.controllers.*;
import plane.controllers.windowJump.ExitApplicationController;
import plane.models.Board;
import plane.views.*;

/**
 * The Class Main.
 * @author Zeqian Li
 */
public class Main {
	/**
	 * Launch the application.
	 * @param args Commend-line arguments
	 */
	public static void main(String[] args) {
		
		Board board = new Board();
		Application g = new Application(board);
		
		g.addWindowListener (new WindowAdapter() {
			/**
			 * window
			 */

			public void windowClosing(WindowEvent e) {
				new ExitApplicationController(g).process();
			}

		});

		// Tell app window that we will be responsible for closing application  
		g.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		g.setVisible(true);
	}
}
package plane.controllers.windowJump;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * Controller to confirm request to exist application.
 * @author
 */
public class ExitApplicationController {

	/** The application frame. */
	JFrame app;

	/**
	 * Instantiates a new exit application controller.
	 *
	 * @param app the application
	 */
	public ExitApplicationController(JFrame app) {
		this.app = app;
	}

	/**
	 * Process.
	 * Ask player to confirm whether he/she wants to exit PuzzlePlane application
	 */
	public void process() {
		int c = JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?");

		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}

}
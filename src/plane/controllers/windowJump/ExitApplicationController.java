package plane.controllers.windowJump;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * Controller to confirm request to exist application.
 */
public class ExitApplicationController {

	/** The app. */
	JFrame app;

	/**
	 * Instantiates a new exit application controller.
	 *
	 * @param app the app
	 */
	public ExitApplicationController(JFrame app) {
		this.app = app;
	}

	/**
	 * Process.
	 */
	public void process() {
		int c = JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?");

		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}

}
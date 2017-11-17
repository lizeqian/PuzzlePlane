package plane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import plane.views.Application;

/**
 * The Class ExitViewShapesetController.
 * The current shapeset display will be closed 
 * and the application will only show the puzzle solving view
 */
public class ExitViewShapesetController implements ActionListener{
	
	/** The plane. */
	Application plane;
	
	/**
	 * Instantiates a new exit view shapeset controller.
	 * 
	 * @param plane the plane
	 */
	public ExitViewShapesetController(Application plane) {
		// TODO Auto-generated constructor stub
		this.plane= plane;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.jumpPage("p3");
	}

}

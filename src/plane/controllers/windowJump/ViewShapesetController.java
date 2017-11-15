package plane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plane.views.Application;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewShapesetController.
 */
public class ViewShapesetController implements ActionListener{

	/** The plane. */
	public Application plane;
	
	/**
	 * Instantiates a new view shapeset controller.
	 *
	 * @param plane the plane
	 */
	public ViewShapesetController(Application plane) {
		// TODO Auto-generated constructor stub
		this.plane = plane;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.jumpPage("p5");
	}

}

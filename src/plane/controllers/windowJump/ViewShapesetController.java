package plane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plane.views.Application;

/**
 * The Class ViewShapesetController.
 * The current shapeset will be displayed
 * @author cheng zhu
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

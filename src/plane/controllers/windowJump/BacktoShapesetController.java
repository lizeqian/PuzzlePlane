package plane.controllers.windowJump;

import java.awt.event.*;

import plane.views.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BacktoShapesetController.
 */
public class BacktoShapesetController implements ActionListener{
	
	/** The puzzle plane gui. */
	Application puzzlePlaneGui;
	
	/**
	 * Instantiates a new backto shapeset controller.
	 *
	 * @param p the p
	 */
	public BacktoShapesetController(Application p) {
		this.puzzlePlaneGui = p;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p1");
	}
}
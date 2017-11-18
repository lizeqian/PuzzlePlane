package plane.controllers.windowJump;

import java.awt.event.*;

import plane.views.*;

/**
 * The Class BacktoShapesetController.
 * When calling this controller, the page will jump to the shapeset selection view.
 * @author Zeqian Li, yinkai ma
 */
public class BacktoShapesetController implements ActionListener{
	
	/** The puzzle plane gui. */
	Application puzzlePlaneGui;
	
	/**
	 * Instantiates a new back to shapeset controller.
	 *
	 * @param p the p
	 */
	public BacktoShapesetController(Application p) {
		this.puzzlePlaneGui = p;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	/** The page will jump to puzzle selection view. */
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p1");
	}
}
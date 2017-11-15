package plane.controllers.windowJump;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class EnterPuzzleSolvingController.
 */
public class EnterPuzzleSolvingController implements ActionListener{
	
	/** The puzzle plane gui. */
	Application puzzlePlaneGui;
	
	/** The board. */
	Board board;
	
	/**
	 * Instantiates a new enter puzzle solving controller.
	 *
	 * @param p the p
	 * @param b the b
	 */
	public EnterPuzzleSolvingController(Application p, Board b) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		
	}
}
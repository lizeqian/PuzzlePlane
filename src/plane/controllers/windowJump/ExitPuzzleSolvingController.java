package plane.controllers.windowJump;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ExitPuzzleSolvingController.
 */
public class ExitPuzzleSolvingController implements ActionListener{
	
	/** The puzzle plane gui. */
	Application puzzlePlaneGui;
	
	/** The board. */
	Board board;
	
	/**
	 * Instantiates a new exit puzzle solving controller.
	 *
	 * @param b the b
	 * @param p the p
	 */
	public ExitPuzzleSolvingController(Board b, Application p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.jumpPage("p2");
	}

	/**
	 * Gets the puzzle plane gui.
	 *
	 * @return the puzzle plane gui
	 */
	public Application getPuzzlePlaneGui() {
		return puzzlePlaneGui;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
}
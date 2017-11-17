package plane.controllers.windowJump;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

/**
 * The Class ExitInfoBoardController.
 * By calling this controller, the application will display the PuzzleSolved view
 */
public class ExitInfoBoardController implements ActionListener {
	
	/** The puzzle plane gui. */
	Application puzzlePlaneGui;
	
	/** The board. */
	Board board;
	
	/**
	 * Instantiates a new exit info board controller.
	 *
	 * @param b the board
	 * @param p the plane
	 */
	public ExitInfoBoardController(Board b, Application p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	/** The page will jump to puzzle selection view, which is SecondPPGui.
	 */
	public void actionPerformed(ActionEvent e) {
		((SecondPPGui)this.puzzlePlaneGui.p_2).reset();
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

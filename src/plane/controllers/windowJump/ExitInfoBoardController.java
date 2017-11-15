package plane.controllers.windowJump;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ExitInfoBoardController.
 */
public class ExitInfoBoardController implements ActionListener {
	
	/** The puzzle plane gui. */
	Application puzzlePlaneGui;
	
	/** The board. */
	Board board;
	
	/**
	 * Instantiates a new exit info board controller.
	 *
	 * @param b the b
	 * @param p the p
	 */
	public ExitInfoBoardController(Board b, Application p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
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

package plane.controllers.windowJump;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

/**
 * The Class ExitPuzzleSolvingController.
 * The PuzzleSolving view will be exited and then display the puzzle selection view, which is SecondPPGui.
 * @author
 */
public class ExitPuzzleSolvingController implements ActionListener{
	
	/** The puzzle plane gui. */
	Application puzzlePlaneGui;
	
	/** The board. */
	Board board;
	
	/**
	 * Instantiates a new exit puzzle solving controller.
	 *
	 * @param b the board
	 * @param p the plane
	 */
	public ExitPuzzleSolvingController(Board b, Application p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	/**
	 * Reset all shapes' position. Return all shapes to their origin position in the palette.
	 * Page jumps to puzzle selection view, which is SecondPPGui.
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
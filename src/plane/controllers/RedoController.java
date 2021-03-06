package plane.controllers;
/** 
 * Class RedoController
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plane.models.Board;
import plane.views.PuzzleSolvingView;

/**
 * The Class RedoController.
 * Redo the last undo move, as requested by user
 * @author cheng zhu
 */
public class RedoController implements ActionListener{
	
	/** The board. */
	public Board board;
	
	/** The plane. */
	public PuzzleSolvingView plane;
	
	/**
	 * Instantiates a new redo controller.
	 *
	 * @param b the board
	 * @param puzzleSolvingView the puzzle solving view Gui
	 */
	public RedoController(Board b, PuzzleSolvingView puzzleSolvingView) {
		this.board = b;
		this.plane = puzzleSolvingView;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.redo();
		this.plane.repaint();
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets the plane.
	 *
	 * @return the plane
	 */
	public PuzzleSolvingView getPlane() {
		return plane;
	}
}

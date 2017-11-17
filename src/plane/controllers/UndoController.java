package plane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plane.models.Board;
import plane.views.Application;
import plane.views.PuzzleSolvingView;

/**
 * The Class UndoController.
 * Undo the last operation of user, as requested by the user
 */
public class UndoController implements ActionListener{
	
	/** The board. */
	public Board board;
	
	/** The plane. */
	public PuzzleSolvingView plane;
	
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

	/**
	 * Instantiates a new undo controller.
	 *
	 * @param b the board
	 * @param puzzleSolvingView the puzzle solving view
	 */
	public UndoController(Board b, PuzzleSolvingView puzzleSolvingView) {
		// TODO Auto-generated constructor stub
		this.board = b;
		this.plane = puzzleSolvingView;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * undo states by "board"
	 * update Gui by "plane"
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.undo();
		this.plane.repaint();
	}

}

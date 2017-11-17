package plane.controllers;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

/**
 * The abstract Class AbstracAction.
 */
public abstract class AbstractAction implements ActionListener{
	
	/** The puzzle solving view. */
	public PuzzleSolvingView puzzleSolvingView;
	
	/** The board. */
	public Board board;
	
	/** The solution check controller. */
	public SolutionCheckController solutionCheckController;
	/**
	 * Define the left and right rotate.
	 */
	public final static int LEFT_ROTATE = 345;
	
	/** The Constant RIGHT_ROTATE. */
	public final static int RIGHT_ROTATE = 15;
	
	/** The selected shape. */
	public PlacedShape selectedShape;
		
	/**
	 * Instantiates a new abstract action.
	 *
	 * @param b the b
	 * @param p the p
	 * @param s the s
	 */
	public AbstractAction (Board b, PuzzleSolvingView p, SolutionCheckController s) {
		/** The puzzleSolvingView p. */
		this.puzzleSolvingView = p;
		/** The board b. */
		this.board = b;
		/** The solutionCheckController s. */
		this.solutionCheckController = s;
	}
}
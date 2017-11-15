package plane.controllers;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;
/**
 * The abstract Class AbstracAction.
 */
public abstract class AbstractAction implements ActionListener{
	public PuzzleSolvingView puzzleSolvingView;
	public Board board;
	public SolutionCheckController solutionCheckController;
	/**
	 * Define the left and right rotate.
	 */
	public final static int LEFT_ROTATE = 345;
	public final static int RIGHT_ROTATE = 15;
	
	public PlacedShape selectedShape;
		
	public AbstractAction (Board b, PuzzleSolvingView p, SolutionCheckController s) {
		/** The puzzleSolvingView p. */
		this.puzzleSolvingView = p;
		/** The board b. */
		this.board = b;
		/** The solutionCheckController s. */
		this.solutionCheckController = s;
	}
}
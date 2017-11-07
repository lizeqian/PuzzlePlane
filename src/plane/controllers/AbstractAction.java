package plane.controllers;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

public abstract class AbstractAction implements ActionListener{
	public PuzzleSolvingView puzzleSolvingView;
	public Board board;
	public SolutionCheckController solutionCheckController;
	
	public final static int LEFT_ROTATE = 345;
	public final static int RIGHT_ROTATE = 15;
	
	public PlacedShape selectedShape;
		
	public AbstractAction (Board b, PuzzleSolvingView p, SolutionCheckController s) {
		this.puzzleSolvingView = p;
		this.board = b;
		this.solutionCheckController = s;
	}
}
package plane.controllers;

import java.awt.Color;

import junit.framework.TestCase;
import plane.models.Board;
import plane.models.Move;
import plane.models.PlacedShape;
import plane.views.Application;
import plane.views.PuzzleSolvingView;

public class ControllerCase extends TestCase {
	
	public Application app;
	public Board board;
	public PuzzleSolvingView plane;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board();
		board.init();
		
		app = new Application(board);
		plane = new PuzzleSolvingView(board, app, 700, 1000);
	}
	
	public void testNothing() { 
		
	}
}

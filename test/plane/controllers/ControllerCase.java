package plane.controllers;

import junit.framework.TestCase;
import plane.models.Board;
import plane.views.Application;
import plane.views.PuzzleSolvingView;


/**
 * The Class ControllerCase.
 * Test case
 * @author cheng zhu
 */
public class ControllerCase extends TestCase {
	
	/** The app. */
	public Application app;
	
	/** The board. */
	public Board board;
	
	/** The plane. */
	public PuzzleSolvingView plane;
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board();
		board.init();
		
		app = new Application(board);
		plane = new PuzzleSolvingView(board, app, 700, 1000);
	}
	
	/**
	 * Test nothing.
	 */
	public void testNothing() { 
		
	}
}

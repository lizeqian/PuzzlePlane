package plane.controllers;

import java.awt.Color;

import plane.models.Move;
import plane.models.PlacedShape;


/**
 * The Class TestRedoController.
 *  Redo the last undo move, as requested by user
 *  Test case
 *  @author cheng zhu
 */
public class TestRedoController extends ControllerCase {
	
	/** The controller. */
	RedoController controller;
	
	/** The move. */
	Move move;
	
	/* (non-Javadoc)
	 * @see plane.controllers.ControllerCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		move = new Move(new PlacedShape(Color.BLUE), new PlacedShape(Color.CYAN));
		board.getMoves().push(move);
		board.undo();
		controller = new RedoController(board, plane);
	}
	
	/**
	 * Test constructor.
	 */
	public void testConstructor() {
		assertEquals(board, controller.getBoard());
		assertEquals(plane, controller.getPlane());
	}
	
	/**
	 * Test action performed.
	 */
	public void testActionPerformed() {
		controller.actionPerformed(null);
		assertEquals(board.getMoves().peek(), move);
		assertTrue(board.getRedoStack().isEmpty());
	}
}

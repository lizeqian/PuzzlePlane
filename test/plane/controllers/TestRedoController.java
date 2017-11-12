package plane.controllers;

import java.awt.Color;

import plane.models.Move;
import plane.models.PlacedShape;

public class TestRedoController extends ControllerCase {
	
	RedoController controller;
	Move move;
	
	protected void setUp() throws Exception {
		super.setUp();
		move = new Move(new PlacedShape(Color.BLUE), new PlacedShape(Color.CYAN));
		board.getMoves().push(move);
		board.undo();
		controller = new RedoController(board, plane);
	}
	
	public void testConstructor() {
		assertEquals(board, controller.getBoard());
		assertEquals(plane, controller.getPlane());
	}
	
	public void testActionPerformed() {
		controller.actionPerformed(null);
		assertEquals(board.getMoves().peek(), move);
		assertTrue(board.getRedoStack().isEmpty());
	}
}

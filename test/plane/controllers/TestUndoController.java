package plane.controllers;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Color;
import junit.framework.TestCase;
import plane.models.Board;
import plane.models.Move;
import plane.models.PlacedShape;
import plane.views.Application;
import plane.views.PuzzleSolvingView;

// TODO: Auto-generated Javadoc
/**
 * The Class TestUndoController.
 */
public class TestUndoController extends ControllerCase{
	
	/** The event. */
	public ActionEvent event;
	
	/** The controller. */
	public UndoController controller;
	
	/** The move. */
	public Move move;
	
	/* (non-Javadoc)
	 * @see plane.controllers.ControllerCase#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		
		move = new Move(new PlacedShape(Color.BLUE), new PlacedShape(Color.CYAN));
		board.getMoves().push(move);
		
		event = null;
		controller = new UndoController(board, plane);
	}
	
	/**
	 * Instantiates a new test undo controller.
	 */
	public TestUndoController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Test contructor.
	 */
	public void testContructor() {
		assertEquals(controller.getBoard(), board);
		assertEquals(controller.getPlane(), plane);
	}
	
	/**
	 * Test action performed.
	 */
	public void testActionPerformed() {
		controller.actionPerformed(null);
		assert(controller.getBoard().getMoves().isEmpty());
		assert(controller.getBoard().getRedoStack().size() == 1);
		assertEquals(controller.getBoard().getRedoStack().peek(), move);
	}

}

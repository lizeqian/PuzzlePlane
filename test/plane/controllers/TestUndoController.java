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

public class TestUndoController extends ControllerCase{
	
	public ActionEvent event;
	public UndoController controller;
	public Move move;
	
	public void setUp() throws Exception {
		super.setUp();
		
		move = new Move(new PlacedShape(Color.BLUE), new PlacedShape(Color.CYAN));
		board.getMoves().push(move);
		
		event = null;
		controller = new UndoController(board, plane);
	}
	
	public TestUndoController() {
		// TODO Auto-generated constructor stub
	}
	
	public void testContructor() {
		assertEquals(controller.getBoard(), board);
		assertEquals(controller.getPlane(), plane);
	}
	
	public void testActionPerformed() {
		controller.actionPerformed(null);
		assert(controller.getBoard().getMoves().isEmpty());
		assert(controller.getBoard().getRedoStack().size() == 1);
		assertEquals(controller.getBoard().getRedoStack().peek(), move);
	}

}

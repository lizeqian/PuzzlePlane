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

public class TestUndoController extends TestCase{
	
	public Board board;
	public Application app;
	public PuzzleSolvingView plane;
	public ActionEvent event;
	public UndoController controller;
	public Move move;
	
	public void setUp() {
		board = new Board();
		board.init();
		move = new Move(new PlacedShape(Color.BLUE), new PlacedShape(Color.CYAN));
		board.moves.push(move);
		
		app = new Application(board);
		plane = new PuzzleSolvingView(board, app, 500, 500);
		event = null;
		controller = new UndoController(board, plane);
	}
	
	public TestUndoController() {
		// TODO Auto-generated constructor stub
	}
	
	public void testContructor() {
		assertEquals(controller.board, board);
		assertEquals(controller.plane, plane);
	}
	
	public void testActionPerformed() {
		controller.actionPerformed(null);
		assert(controller.board.moves.isEmpty());
		assert(controller.board.redoStack.size() == 1);
		assertEquals(controller.board.redoStack.peek(), move);
	}

}

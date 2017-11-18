package plane.controllers;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import junit.framework.TestCase;
import plane.models.Board;
import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.models.ShapeStatus;
import plane.views.Application;
import plane.views.PuzzleSolvingView;

//
/**
 * The Class TestMoveShapePaletteSolutionController.
 * TestCase
 * @author Zeqian Li
 */
public class TestMoveShapePaletteSolutionController extends generic.MouseEventTestCase {
	
	/** The board. */
	Board board;
	
	/** The ap. */
	Application ap;
	
	/** The psv. */
	PuzzleSolvingView psv;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() {
		this.board = new Board();
		this.ap = new Application(this.board);
		PlacedShape ps = new PlacedShape(Color.BLACK);
		ps.setPosition(20, 20);
		ps.addPoint(20, 20);
		ps.addPoint(30, 20);
		ps.addPoint(25, 30);
		ps.addPoint(20, 20);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps);
		this.board.setShapes(shapes);
		
		PlacedShape ps2 = new PlacedShape(Color.BLACK);
		ps2.addPoint(200, 200);
		ps2.addPoint(250, 200);
		ps2.addPoint(250, 300);
		ps2.addPoint(200, 300);
		ps2.addPoint(200, 200);
		ArrayList<PlacedShape> shapes2 = new ArrayList<PlacedShape>();
		shapes2.add(ps2);
		
		Puzzle puzzle = new Puzzle("test");
		puzzle.setShape(shapes2);
		this.board.setPuzzle(puzzle);
		this.psv = new PuzzleSolvingView(this.board, this.ap, 1000, 700);
		this.ap.setVisible(true);
		this.ap.jumpPage("p3");	
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() {
		this.ap.setVisible(false);
	}
 
	/**
	 * Test move.
	 */
	public void testMove() {
		SolutionCheckController sccontroller = new SolutionCheckController(this.board, this.ap);
		MoveShapePaletteSolutionController controller = new MoveShapePaletteSolutionController(this.board, this.ap, this.psv, 700, 1000, sccontroller);
		controller.mousePressed(this.createPressed(this.psv, 25, 25));
		assertTrue(this.board.getShapes().get(0).isSelected());		
		controller.mouseReleased(this.createReleased(this.psv, 25, 25));
		assertFalse(this.board.getShapes().get(0).isSelected());
	}
}

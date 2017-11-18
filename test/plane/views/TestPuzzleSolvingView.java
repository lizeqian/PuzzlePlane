package plane.views;

import java.awt.Color;

import java.awt.Polygon;
import java.util.ArrayList;

import junit.framework.TestCase;
import plane.models.Board;
import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.models.ShapeStatus;

/**
 * The Class PuzzleSolvingView.
 * TestCase
 * @author Zeqian Li
 */

public class TestPuzzleSolvingView extends TestCase {
	
	/** The puzzle solving view. */
	PuzzleSolvingView psv;
	
	/** The application. */
	Application ap;
	
	/** The board. */
	Board board;
	/** Create the polygon.
	 * add point of the polygon
	 * @param x left top point x
	 * @param y left top point y
	 * @return a created polygon
     */
	
	public Polygon createPolygon(int x, int y) {
		Polygon polygon = new Polygon();
		polygon.addPoint(x, y);
		polygon.addPoint(x+10, y);
		polygon.addPoint(x+5, y+10);
		polygon.addPoint(x, y);
		return polygon;
	}
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() {
		board = new Board();
		this.ap = new Application(board);
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		ps.setOriginalPolygon(p);
		ps.setChangedPolygon(p);
		ShapeStatus ss = new ShapeStatus(Color.BLACK);
		ss.select();
		ps.setStatus(ss);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps);
		board.setShapes(shapes);
		
		Puzzle puzzle = new Puzzle("test");
		puzzle.setShape(shapes);
		board.setPuzzle(puzzle);
		this.psv = new PuzzleSolvingView(board, this.ap, 700, 1000);
		this.ap.setVisible(true);
		this.ap.jumpPage("p3");
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() {
		if (this.ap != null) {
			this.ap.dispose();
		}
	}
	
	/**
	 * Test application.
	 */
	public void testApp() {
		System.out.println("Sample Puzzle Solving View");
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		ps.setOriginalPolygon(p);
		ps.setChangedPolygon(p);
		ShapeStatus ss = new ShapeStatus(Color.BLACK);
		ss.select();
		ps.setStatus(ss);
		assertEquals(this.board.getShapes().get(0).toString(), ps.toString());
	}

}

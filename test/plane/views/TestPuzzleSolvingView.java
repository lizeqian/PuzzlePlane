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
 */

public class TestPuzzleSolvingView extends TestCase {
	PuzzleSolvingView psv;
	Application ap;
	Board board;
	/** Create the polygon.
	 * add the point of the polygon
     */
	
	public Polygon createPolygon(int x, int y) {
		Polygon polygon = new Polygon();
		polygon.addPoint(x, y);
		polygon.addPoint(x+10, y);
		polygon.addPoint(x+5, y+10);
		polygon.addPoint(x, y);
		return polygon;
	}
	
	
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
	
	protected void tearDown() {
		if (this.ap != null) {
			this.ap.dispose();
		}
	}
	
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

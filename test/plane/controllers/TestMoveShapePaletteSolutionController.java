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

public class TestMoveShapePaletteSolutionController extends generic.MouseEventTestCase {
	Board board;
	Application ap;
	PuzzleSolvingView psv;
	
	public Polygon createPolygon(int x, int y) {
		Polygon polygon = new Polygon();
		polygon.addPoint(x, y);
		polygon.addPoint(x+10, y);
		polygon.addPoint(x+5, y+10);
		polygon.addPoint(x, y);
		return polygon;
	}
	
	protected void setUp() {
		this.board = new Board();
		this.ap = new Application(this.board);
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(20, 20);
		ps.setOriginalPolygon(p);
		ps.setChangedPolygon(p);
		ShapeStatus ss = new ShapeStatus(Color.BLACK);
		ps.setStatus(ss);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps);
		this.board.setShapes(shapes);
		
		PlacedShape ps2 = new PlacedShape(Color.BLACK);
		Polygon p2 = this.createPolygon(100, 100);
		ps.setOriginalPolygon(p2);
		ps.setChangedPolygon(p2);
		ArrayList<PlacedShape> shapes2 = new ArrayList<PlacedShape>();
		shapes2.add(ps2);
		
		Puzzle puzzle = new Puzzle();
		puzzle.setShape(shapes2);
		this.board.setPuzzle(puzzle);
		this.psv = new PuzzleSolvingView(this.board, this.ap, 700, 1000);
		this.ap.setVisible(true);
		this.ap.jumpPage("p3");	
	}
	
	protected void tearDown() {
		this.ap.setVisible(false);
	}
 
	public void testMove() {
		SolutionCheckController sccontroller = new SolutionCheckController(this.board, this.ap);
		MoveShapePaletteSolutionController controller = new MoveShapePaletteSolutionController(this.board, this.ap, this.psv, 700, 1000, sccontroller);
		controller.mousePressed(this.createPressed(this.psv, 25, 25));
		assertTrue(this.board.getShapes().get(0).isSelected());
	}
}

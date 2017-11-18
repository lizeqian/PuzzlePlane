package plane.models;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import junit.framework.TestCase;


/**
 * The Class TestPuzzle.
 * @author Zeqian Li
 */
public class TestPuzzle extends TestCase {
	
	/**
	 * Test constructor.
	 */
	public void testConstructor() {
		ArrayList<PlacedShape> shapesBefore = new ArrayList<PlacedShape>();
		Polygon polygon0 = new Polygon();
		polygon0.addPoint(1, 1);
		polygon0.addPoint(2, 2);
		polygon0.addPoint(3, 3);
		polygon0.addPoint(1, 1);
		PlacedShape shape0 = new PlacedShape(Color.BLACK);
		shape0.setOriginalPolygon(polygon0);
		shapesBefore.add(shape0);
		Puzzle p = new Puzzle(shapesBefore);
		assertEquals(shapesBefore, p.getPuzzleShape());
		
	}
	
	/**
	 * Test get last solution.
	 */
	public void testGetLastSolution() {
		Puzzle p = new Puzzle("test");
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		Polygon polygon = new Polygon();
		polygon.addPoint(1, 1);
		polygon.addPoint(2, 2);
		polygon.addPoint(3, 3);
		polygon.addPoint(1, 1);
		PlacedShape shape = new PlacedShape(Color.BLACK);
		shape.setOriginalPolygon(polygon);
		shapes.add(shape);
		
	}
	
	/**
	 * Test set shape.
	 */
	public void testSetShape() {
		ArrayList<PlacedShape> shapesBefore = new ArrayList<PlacedShape>();
		ArrayList<PlacedShape> shapesAfter = new ArrayList<PlacedShape>();
		Polygon polygon0 = new Polygon();
		Polygon polygon1 = new Polygon();
		polygon0.addPoint(1, 1);
		polygon0.addPoint(2, 2);
		polygon0.addPoint(3, 3);
		polygon0.addPoint(1, 1);
		polygon1.addPoint(4, 4);
		polygon1.addPoint(2, 2);
		polygon1.addPoint(3, 3);
		polygon1.addPoint(4, 4);
		PlacedShape shape0 = new PlacedShape(Color.BLACK);
		PlacedShape shape1 = new PlacedShape(Color.BLUE);
		shape0.setOriginalPolygon(polygon0);
		shape1.setOriginalPolygon(polygon1);
		shapesBefore.add(shape0);
		shapesAfter.add(shape1);
		Puzzle p = new Puzzle(shapesBefore);
		p.setShape(shapesAfter);
		assertEquals(shapesAfter, p.getPuzzleShape());
		
	}
}

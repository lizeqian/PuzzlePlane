package plane.models;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;


/**
 * The Class TestBoardMemento.
 * @author Zeqian Li
 */
public class TestBoardMemento extends TestCase {
	
	/** The board. */
	Board b;
	
	/**
	 * Creates the polygon.
	 *
	 * @param x the horizontal coordinate
	 * @param y the vertical coordinate
	 * @return the polygon
	 */
	public Polygon createPolygon(int x, int y) {
		Polygon polygon = new Polygon();
		polygon.addPoint(x, y);
		polygon.addPoint(x+10, y);
		polygon.addPoint(x+5, y+10);
		polygon.addPoint(x, y);
		return polygon;
	}
	
	/**
	 * Creates the placed shape.
	 *
	 * @param p1 the page 1, which is the shapeset selection view.
	 * @param p2 the page 2, which is the puzzle selection view.
	 * @return the placed shape
	 */
	public PlacedShape createPlacedShape(Polygon p1, Polygon p2) {
		PlacedShape shape = new PlacedShape(Color.BLACK);
		shape.setOriginalPolygon(p1);
		shape.setChangedPolygon(p2);
		return shape;
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() throws Exception{
		super.setUp();
		
		b = new Board();
		List<PlacedShape> shapes = new ArrayList<>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		b.setShapes(shapes);
		b.setPuzzle(new Puzzle("test"));
		b.setShapeset(new Shapeset("traditional"));
	}
		
	/**
	 * Test constructor.
	 */
	public void testConstructor() {
		BoardMemento bm = new BoardMemento(b);
	}
	
	/**
	 * Test set shape.
	 */
	public void testSetShape() {
		BoardMemento bm = new BoardMemento(b);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		bm.setShapes(shapes);
		assertEquals(shapes.get(0).toString(), bm.shapes.get(0).toString());
	}
	
	/**
	 * Test get shapes.
	 */
	public void testGetShapes() {
		BoardMemento bm = new BoardMemento(b);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		bm.setShapes(shapes);
		assertEquals(shapes.get(0).toString(), bm.getShapes().get(0).toString());
	}
}

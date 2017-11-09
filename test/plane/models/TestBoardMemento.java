package plane.models;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import junit.framework.TestCase;

public class TestBoardMemento extends TestCase {
	public Polygon createPolygon(int x, int y) {
		Polygon polygon = new Polygon();
		polygon.addPoint(x, y);
		polygon.addPoint(x+10, y);
		polygon.addPoint(x+5, y+10);
		polygon.addPoint(x, y);
		return polygon;
	}
	
	public PlacedShape createPlacedShape(Polygon p1, Polygon p2) {
		PlacedShape shape = new PlacedShape(Color.BLACK);
		shape.setOriginalPolygon(p1);
		shape.setChangedPolygon(p2);
		return shape;
	}
	
	public void testConstructor() {
		Board b = new Board();
		BoardMemento bm = new BoardMemento(b);
	}
	
	public void testSetShape() {
		Board b = new Board();
		BoardMemento bm = new BoardMemento(b);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		bm.setShapes(shapes);
		assertEquals(shapes.get(0).toString(), bm.shapes.get(0).toString());
	}
	
	public void testGetShapes() {
		Board b = new Board();
		BoardMemento bm = new BoardMemento(b);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		bm.setShapes(shapes);
		assertEquals(shapes.get(0).toString(), bm.getShapes().get(0).toString());
	}
}

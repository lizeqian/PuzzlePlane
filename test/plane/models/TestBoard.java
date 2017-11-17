package plane.models;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import junit.framework.TestCase;
import plane.utils.PolygonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestBoard.
 */
public class TestBoard extends TestCase {
	
	/**
	 * Creates the polygon.
	 *
	 * @param x the x
	 * @param y the y
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
	 * @param p1 the p 1
	 * @param p2 the p 2
	 * @return the placed shape
	 */
	public PlacedShape createPlacedShape(Polygon p1, Polygon p2) {
		PlacedShape shape = new PlacedShape(Color.BLACK);
		shape.setOriginalPolygon(p1);
		shape.setChangedPolygon(p2);
		return shape;
	}
	
	/**
	 * Test get puzzle.
	 */
	public void testGetPuzzle() {
		Board b = new Board();
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		Puzzle p = new Puzzle(shapes);
		b.setPuzzle(p);
		assertEquals(p, b.getPuzzle());
	}
	
	/**
	 * Test get shapes.
	 */
	public void testGetShapes() {
		Board b = new Board();
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		b.setShapes(shapes);
		for (int i = 0; i < shapes.size(); i++) {
			assertEquals(shapes.get(i).toString(), b.getShapes().get(i).toString());
		}
	}
	
	/**
	 * Test get selected shape.
	 */
	public void testGetSelectedShape() {
		Board b = new Board();
		PlacedShape shape = this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1));
		b.setSelectedShape(shape);
		assertEquals(shape, b.getSelectedShape());
	}
	
	/**
	 * Test select shape.
	 */
	public void testSelectShape() {
		Board b = new Board();
		Polygon p1 = this.createPolygon(1, 1);
		Polygon p2 = this.createPolygon(20, 20);
		PlacedShape ps1 = this.createPlacedShape(p1, p1);
		PlacedShape ps2 = this.createPlacedShape(p1, p2);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		shapes.add(ps2);
		b.setShapes(shapes);
		b.selectShape(100, 100);
		b.selectShape(25, 22);
		b.selectShape(5, 2);
		ps1.selectShape();
		assertEquals(ps1.toString(), b.getSelectedShape().toString());
	}
	
	/**
	 * Test set position.
	 */
	public void testSetPosition() {
		Board b = new Board();
		Polygon p1 = this.createPolygon(1, 1);
		Polygon p2 = this.createPolygon(20, 20);
		PlacedShape ps1 = this.createPlacedShape(p1, p1);
		PlacedShape ps2 = this.createPlacedShape(p1, p2);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		shapes.add(ps2);
		b.setShapes(shapes);
		b.selectShape(5, 2);
		b.setPosition(1, 1);
		
		Polygon expected = this.createPolygon(2, 2);
		assertEquals(PolygonUtils.toString(b.getSelectedShape().getChangedPolygon()), PolygonUtils.toString(expected));
	}
	
	/**
	 * Test reset position.
	 */
	public void testResetPosition() {
		Board b = new Board();
		Polygon p1 = this.createPolygon(1, 1);
		Polygon p2 = this.createPolygon(20, 20);
		PlacedShape ps1 = this.createPlacedShape(p1, p1);
		PlacedShape ps2 = this.createPlacedShape(p2, p2);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		shapes.add(ps2);
		b.setShapes(shapes);
		b.selectShape(25, 22);
		b.setPosition(1, 1);
		b.resetAllShapePosition();
		for (int i=0; i < shapes.size();i++) {
			assertEquals(b.getShapes().get(i).toString(), shapes.get(i).toString());
		}
	}
	
	/**
	 * Test rotate.
	 */
	public void testRotate() {
		Board b = new Board();
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 0);
		polygon.addPoint(5, 9);
		polygon.addPoint(0, 0);
		PlacedShape ps1 = this.createPlacedShape(polygon, polygon);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		b.setShapes(shapes);
		b.selectShape(5, 2);
		b.rotate(90);
		
		Polygon rp = new Polygon();
		rp.addPoint(0, 0);
		rp.addPoint(10, 0);
		rp.addPoint(5, 9);
		rp.addPoint(0, 0);
		PlacedShape ps2 = this.createPlacedShape(PolygonUtils.copy(rp), PolygonUtils.copy(rp));
		ps2.selectShape();
		ps2.rotate(90);
		assertEquals(b.getSelectedShape().toString(), ps2.toString());
	}
	
	/**
	 * Test V flip.
	 */
	public void testVFlip() {
		Board b = new Board();
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 0);
		polygon.addPoint(5, 9);
		polygon.addPoint(0, 0);
		PlacedShape ps1 = this.createPlacedShape(polygon, polygon);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		b.setShapes(shapes);
		b.selectShape(5, 2);
		b.vFlip();
		
		Polygon rp = new Polygon();
		rp.addPoint(0, 0);
		rp.addPoint(10, 0);
		rp.addPoint(5, 9);
		rp.addPoint(0, 0);
		PlacedShape ps2 = this.createPlacedShape(PolygonUtils.copy(rp), PolygonUtils.copy(rp));
		ps2.selectShape();
		ps2.vFlip();
		assertEquals(b.getSelectedShape().toString(), ps2.toString());
	}
	
	/**
	 * Test H flip.
	 */
	public void testHFlip() {
		Board b = new Board();
		b.setPuzzle(new Puzzle("test"));
		b.setShapeset(new Shapeset("traditional"));
		
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 0);
		polygon.addPoint(5, 9);
		polygon.addPoint(0, 0);
		PlacedShape ps1 = this.createPlacedShape(polygon, polygon);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		b.setShapes(shapes);
		b.selectShape(5, 2);
		b.hFlip();
		
		Polygon rp = new Polygon();
		rp.addPoint(0, 0);
		rp.addPoint(10, 0);
		rp.addPoint(5, 9);
		rp.addPoint(0, 0);
		PlacedShape ps2 = this.createPlacedShape(PolygonUtils.copy(rp), PolygonUtils.copy(rp));
		ps2.selectShape();
		ps2.hFlip();
		assertEquals(b.getSelectedShape().toString(), ps2.toString());
	}
	
	/**
	 * Test create memento.
	 */
	public void testCreateMemento() {
		Board b = new Board();
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(this.createPlacedShape(this.createPolygon(1, 1), this.createPolygon(1, 1)));
		b.setShapes(shapes);
		b.setPuzzle(new Puzzle("test"));
		b.setShapeset(new Shapeset("traditional"));
		BoardMemento bm = b.createMemento();
		assertEquals(bm.shapes.get(0).toString(), shapes.get(0).toString());
	}
	
	/**
	 * Test undo.
	 */
	public void testUndo() {
		Board b = new Board();
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 0);
		polygon.addPoint(5, 9);
		polygon.addPoint(0, 0);
		PlacedShape ps1 = this.createPlacedShape(polygon, polygon);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		b.setShapes(shapes);
		b.selectShape(5, 2);
		b.rotate(90);
		b.undo();
		ps1.selectShape();
		assertEquals(b.getSelectedShape().toString(), ps1.toString());
	}
	
	/**
	 * Test redo.
	 */
	public void testRedo() {
		Board b = new Board();
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 0);
		polygon.addPoint(5, 9);
		polygon.addPoint(0, 0);
		PlacedShape ps1 = this.createPlacedShape(polygon, polygon);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		b.setShapes(shapes);
		b.selectShape(5, 2);
		b.rotate(90);
		b.undo();
		b.redo();
		
		Polygon rp = new Polygon();
		rp.addPoint(0, 0);
		rp.addPoint(10, 0);
		rp.addPoint(5, 9);
		rp.addPoint(0, 0);
		PlacedShape ps2 = this.createPlacedShape(PolygonUtils.copy(rp), PolygonUtils.copy(rp));
		ps2.selectShape();
		ps2.rotate(90);
		assertEquals(b.getSelectedShape().toString(), ps2.toString());
	}
	
	/**
	 * Test push drag.
	 */
	public void testPushDrag() {
		Board b = new Board();
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 0);
		polygon.addPoint(5, 9);
		polygon.addPoint(0, 0);
		PlacedShape ps1 = this.createPlacedShape(polygon, polygon);
		ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
		shapes.add(ps1);
		b.setShapes(shapes);
		b.selectShape(5, 2);
		b.rotate(90);
		b.undo();
		b.redo();
		b.pushDrag(ps1);
		assertTrue(b.redoStack.isEmpty());
		assertEquals(b.moves.pop().beforeShape.toString(), ps1.toString());
		
	}
}

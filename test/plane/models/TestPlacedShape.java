package plane.models;

import java.awt.Color;
import java.awt.Polygon;

import junit.framework.TestCase;
import plane.utils.PolygonUtils;


/**
 * The Class TestPlacedShape.
 */
public class TestPlacedShape extends TestCase {
	
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
	 * Test constructor.
	 */
	public void testConstructor() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		assertEquals(ps.getColor(), Color.BLACK);
		PlacedShape ps2 = new PlacedShape(ps);
		assertEquals(ps2.toString(), ps.toString());
	}
	
	/**
	 * Test to solution string.
	 */
	public void testToSolutionString() {
		Polygon polygon = new Polygon();
		polygon.addPoint(10, 10);
		polygon.addPoint(10, 20);
		polygon.addPoint(20, 10);
		polygon.addPoint(10, 10);
		PlacedShape ps = new PlacedShape(Color.RED);
		ps.setChangedPolygon(polygon);
		assertEquals(ps.toSolutionString(), "255 0 0 10 10 10 20 20 10 10 10");
	}
	
	/**
	 * Test get status.
	 */
	public void testGetStatus() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		ShapeStatus ss = new ShapeStatus(Color.BLACK);
		
		ps.setStatus(ss);
		assertEquals(ss, ps.getStatus());
	}
	
	/**
	 * Test get original polygon.
	 */
	public void testGetOriginalPolygon() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		ps.setOriginalPolygon(p);
		
		assertEquals(ps.getOriginalPolygon(), p);
	}
	
	/**
	 * Test copy.
	 */
	public void testCopy() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		assertEquals(ps.toString(), ps.copy().toString());
	}
	
	/**
	 * Test add point.
	 */
	public void testAddPoint() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		for (int i = 0; i < p.npoints; i++) {
			ps.addPoint(p.xpoints[i], p.ypoints[i]);
		}
		
		Polygon p2 = ps.getOriginalPolygon();
		assertEquals(p.npoints, p2.npoints);
		for (int i = 0; i < p.npoints; i++) {
			assertEquals(p2.xpoints[i], p.xpoints[i]);
			assertEquals(p2.ypoints[i], p.ypoints[i]);
		}
	}
	
	/**
	 * Test is selected.
	 */
	public void testIsSelected() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.selectShape();
		assertTrue(p.isSelected());
	}
	
	/**
	 * Test get left horizontal coordinate.
	 */
	public void testGetLeftX() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(0, p.getLeftX());
	}
	
	/**
	 * Test get right horizontal coordinate.
	 */
	public void testGetRightX() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(10, p.getRightX());
	}
	
	/**
	 * Test get top vertical coordinate.
	 */
	public void testGetTopY() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(0, p.getTopY());
	}
	
	/**
	 * Test get bottom vertical coordinate.
	 */
	public void testGetBottomY() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(20, p.getBottomY());
	}
	
	/**
	 * Test rotate.
	 */
	public void testRotate() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.rotate(90);
		
		Polygon p2 = new Polygon();
		p2.addPoint(8, -2);
		p2.addPoint(8, 8);
		p2.addPoint(-1, 3);
		p2.addPoint(8, -2);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
	
	/**
	 * Test Vertical flip.
	 */
	public void testVFlip() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.vFlip();
		
		Polygon p2 = new Polygon();
		p2.addPoint(0, 6);
		p2.addPoint(10, 6);
		p2.addPoint(5, -3);
		p2.addPoint(0, 6);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
	
	/**
	 * Test Horizontal flip.
	 */
	public void testHFlip() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.hFlip();
		
		Polygon p2 = new Polygon();
		p2.addPoint(10, 0);
		p2.addPoint(0, 0);
		p2.addPoint(5, 9);
		p2.addPoint(10, 0);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
	
	/**
	 * Test reset position.
	 */
	public void testResetPos() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.hFlip();
		p.resetPos();
		
		PlacedShape p2 = new PlacedShape(Color.BLACK);
		p2.addPoint(0, 0);
		p2.addPoint(10, 0);
		p2.addPoint(5, 9);
		p2.addPoint(0, 0);
		assertEquals(p.toString(), p2.toString());
	}
	
	/**
	 * Test set changed polygon.
	 */
	public void testSetChangedPolygon() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		ps.setChangedPolygon(p);
		assertEquals(p, ps.changedPolygon);
	}
	
	/**
	 * Test set position.
	 */
	public void testSetPosition() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.setPosition(1, 1);
		
		Polygon p2 = new Polygon();
		p2.addPoint(1, 1);
		p2.addPoint(11, 1);
		p2.addPoint(6, 10);
		p2.addPoint(1, 1);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
}
